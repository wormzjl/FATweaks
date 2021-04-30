package wormz.fatweaks.ASM;

import net.minecraft.launchwrapper.IClassTransformer;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Label;
import org.objectweb.asm.tree.*;

public class IPTransformer implements IClassTransformer {
    @Override
    public byte[] transform(String name, String transformedName, byte[] bytes) {
        if (name.equals("flaxbeard.immersivepetroleum.common.gui.ContainerDistillationTower")) {
            ClassReader cr = new ClassReader(bytes);
            ClassNode cn = new ClassNode();
            cr.accept(cn, 0);
            for (MethodNode mn : cn.methods) {
                if (mn.name.equals("<init>")) {
                    AbstractInsnNode n = mn.instructions.getFirst();
                    while (n != null) {
                        if (n.getOpcode() == Opcodes.ICONST_2) {
                            break;
                        }
                        n = n.getNext();
                    }
                    if (n != null) {
                        mn.instructions.set(n, new InsnNode(Opcodes.ICONST_0));
                    }
                }
            }
            ClassWriter cw = new ClassWriter(0);
            cn.accept(cw);
            return cw.toByteArray();
        } else if (name.equals("flaxbeard.immersivepetroleum.common.blocks.metal.TileEntityDistillationTower")){
            ClassReader cr = new ClassReader(bytes);
            ClassNode cn = new ClassNode();
            cr.accept(cn, 0);
            for (MethodNode mn : cn.methods) {
                if (mn.name.equals("additionalCanProcessCheck")) {
                    mn.instructions.clear();
                    Label label0 = new Label();
                    mn.visitLabel(label0);
                    mn.visitLineNumber(492, label0);
                    mn.visitInsn(Opcodes.ICONST_0);
                    mn.visitVarInsn(Opcodes.ISTORE, 2);
                    Label label1 = new Label();
                    mn.visitLabel(label1);
                    mn.visitLineNumber(493, label1);
                    mn.visitVarInsn(Opcodes.ALOAD, 1);
                    mn.visitFieldInsn(Opcodes.GETFIELD, "blusunrize/immersiveengineering/common/blocks/metal/TileEntityMultiblockMetal$MultiblockProcess", "recipe", "Lblusunrize/immersiveengineering/api/crafting/IMultiblockRecipe;");
                    mn.visitTypeInsn(Opcodes.CHECKCAST, "flaxbeard/immersivepetroleum/api/crafting/DistillationRecipe");
                    mn.visitFieldInsn(Opcodes.GETFIELD, "flaxbeard/immersivepetroleum/api/crafting/DistillationRecipe", "fluidOutput", "[Lnet/minecraftforge/fluids/FluidStack;");
                    mn.visitVarInsn(Opcodes.ASTORE, 3);
                    mn.visitVarInsn(Opcodes.ALOAD, 3);
                    mn.visitInsn(Opcodes.ARRAYLENGTH);
                    mn.visitVarInsn(Opcodes.ISTORE, 4);
                    mn.visitInsn(Opcodes.ICONST_0);
                    mn.visitVarInsn(Opcodes.ISTORE, 5);
                    Label label2 = new Label();
                    mn.visitLabel(label2);
                    mn.visitFrame(Opcodes.F_FULL, 6, new Object[] {"flaxbeard/immersivepetroleum/common/blocks/metal/TileEntityDistillationTower", "blusunrize/immersiveengineering/common/blocks/metal/TileEntityMultiblockMetal$MultiblockProcess", Opcodes.INTEGER, "[Lnet/minecraftforge/fluids/FluidStack;", Opcodes.INTEGER, Opcodes.INTEGER}, 0, new Object[] {});
                    mn.visitVarInsn(Opcodes.ILOAD, 5);
                    mn.visitVarInsn(Opcodes.ILOAD, 4);
                    Label label3 = new Label();
                    mn.visitJumpInsn(Opcodes.IF_ICMPGE, label3);
                    mn.visitVarInsn(Opcodes.ALOAD, 3);
                    mn.visitVarInsn(Opcodes.ILOAD, 5);
                    mn.visitInsn(Opcodes.AALOAD);
                    mn.visitVarInsn(Opcodes.ASTORE, 6);
                    Label label4 = new Label();
                    mn.visitLabel(label4);
                    mn.visitLineNumber(494, label4);
                    mn.visitVarInsn(Opcodes.ILOAD, 2);
                    mn.visitVarInsn(Opcodes.ALOAD, 6);
                    mn.visitFieldInsn(Opcodes.GETFIELD, "net/minecraftforge/fluids/FluidStack", "amount", "I");
                    mn.visitInsn(Opcodes.IADD);
                    mn.visitVarInsn(Opcodes.ISTORE, 2);
                    Label label5 = new Label();
                    mn.visitLabel(label5);
                    mn.visitLineNumber(493, label5);
                    mn.visitIincInsn(5, 1);
                    mn.visitJumpInsn(Opcodes.GOTO, label2);
                    mn.visitLabel(label3);
                    mn.visitLineNumber(496, label3);
                    mn.visitFrame(Opcodes.F_CHOP,3, null, 0, null);
                    mn.visitVarInsn(Opcodes.ALOAD, 0);
                    mn.visitFieldInsn(Opcodes.GETFIELD, "flaxbeard/immersivepetroleum/common/blocks/metal/TileEntityDistillationTower", "tanks", "[Lblusunrize/immersiveengineering/common/util/inventory/MultiFluidTank;");
                    mn.visitInsn(Opcodes.ICONST_1);
                    mn.visitInsn(Opcodes.AALOAD);
                    mn.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "blusunrize/immersiveengineering/common/util/inventory/MultiFluidTank", "getCapacity", "()I", false);
                    mn.visitVarInsn(Opcodes.ALOAD, 0);
                    mn.visitFieldInsn(Opcodes.GETFIELD, "flaxbeard/immersivepetroleum/common/blocks/metal/TileEntityDistillationTower", "tanks", "[Lblusunrize/immersiveengineering/common/util/inventory/MultiFluidTank;");
                    mn.visitInsn(Opcodes.ICONST_1);
                    mn.visitInsn(Opcodes.AALOAD);
                    mn.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "blusunrize/immersiveengineering/common/util/inventory/MultiFluidTank", "getFluidAmount", "()I", false);
                    mn.visitVarInsn(Opcodes.ILOAD, 2);
                    mn.visitInsn(Opcodes.IADD);
                    Label label6 = new Label();
                    mn.visitJumpInsn(Opcodes.IF_ICMPLT, label6);
                    mn.visitInsn(Opcodes.ICONST_1);
                    Label label7 = new Label();
                    mn.visitJumpInsn(Opcodes.GOTO, label7);
                    mn.visitLabel(label6);
                    mn.visitFrame(Opcodes.F_SAME, 0, null, 0, null);
                    mn.visitInsn(Opcodes.ICONST_0);
                    mn.visitLabel(label7);
                    mn.visitFrame(Opcodes.F_SAME1, 0, null, 1, new Object[] {Opcodes.INTEGER});
                    mn.visitInsn(Opcodes.IRETURN);
                    Label label8 = new Label();
                    mn.visitLabel(label8);
                    mn.visitLocalVariable("outputFluid", "Lnet/minecraftforge/fluids/FluidStack;", null, label4, label5, 6);
                    mn.visitLocalVariable("this", "Lflaxbeard/immersivepetroleum/common/blocks/metal/TileEntityDistillationTower;", null, label0, label8, 0);
                    mn.visitLocalVariable("process", "Lblusunrize/immersiveengineering/common/blocks/metal/TileEntityMultiblockMetal$MultiblockProcess;", "Lblusunrize/immersiveengineering/common/blocks/metal/TileEntityMultiblockMetal$MultiblockProcess<Lflaxbeard/immersivepetroleum/api/crafting/DistillationRecipe;>;", label0, label8, 1);
                    mn.visitLocalVariable("outputAmount", "I", null, label1, label8, 2);
                    mn.visitMaxs(3, 7);
                    mn.visitEnd();
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
