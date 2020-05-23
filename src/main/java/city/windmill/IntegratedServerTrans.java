package city.windmill;

import net.minecraft.launchwrapper.IClassTransformer;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.tree.*;
import wormz.fatweaks.ASM.FATCore;

public class IntegratedServerTrans implements IClassTransformer {
    @Override
    public byte[] transform(String name, String transformedName, byte[] bytes) {
        if (transformedName.equals("net.minecraft.server.integrated.IntegratedServer")) {
            ClassReader cr = new ClassReader(bytes);
            ClassNode cn = new ClassNode();
            cr.accept(cn, 0);
            for (MethodNode mn : cn.methods) {
                if (mn.name.matches("initiateShutdown|x")) {
                    AbstractInsnNode n = mn.instructions.getFirst();
                    while (n != null) {
                        if (n.getOpcode() == Opcodes.IFEQ) {
                            break;
                        }
                        n = n.getNext();
                    }
                    if (n != null) {
                        InsnList codes = new InsnList();
                        codes.add(new VarInsnNode(Opcodes.ALOAD,0));
                        codes.add(new MethodInsnNode(Opcodes.INVOKESPECIAL,
                                "net/minecraft/server/MinecraftServer",
                                FATCore.isDeobf ? "initiateShutdown" : "func_71263_m",
                                "()V",
                                false));
                        mn.instructions.insert(codes);
                        FATCore.LOGGER.info("Injected: " + transformedName);
                    }
                }
            }
            ClassWriter cw = new ClassWriter(0);
            cn.accept(cw);
            return cw.toByteArray();
        }
        return bytes;
    }
}
