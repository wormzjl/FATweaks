package wormz.fatweaks.ASM;

import net.minecraft.launchwrapper.IClassTransformer;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.tree.*;

public class RHTransformer implements IClassTransformer {
    @Override
    public byte[] transform(String name, String transformedName, byte[] bytes) {
        if (name.equals("com.globbypotato.rockhounding_chemistry.machines.tile.TEGanController")) {
            ClassReader cr = new ClassReader(bytes);
            ClassNode cn = new ClassNode();
            cr.accept(cn, 0);
            for (MethodNode mn : cn.methods) {
                if (mn.name.equals("num_He")) {
                    mn.instructions.clear();
                    mn.visitInsn(Opcodes.ICONST_0);
                    mn.visitInsn(Opcodes.IRETURN);
                }
            }
            ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
            cn.accept(cw);
            return cw.toByteArray();
        } else {
            return bytes;
        }
    }
}
