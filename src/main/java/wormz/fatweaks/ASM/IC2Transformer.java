package wormz.fatweaks.ASM;

import net.minecraft.launchwrapper.IClassTransformer;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.tree.*;

public class IC2Transformer implements IClassTransformer {
    @Override
    public byte[] transform(String name, String transformedName, byte[] bytes) {
        if (name.equals("ic2.core.block.wiring.TileEntityElectricBatBox")) {
            ClassReader cr = new ClassReader(bytes);
            ClassNode cn = new ClassNode();
            cr.accept(cn, 0);
            for (MethodNode mn : cn.methods) {
                if (mn.name.equals("<init>")) {
                    AbstractInsnNode n = mn.instructions.getFirst();
                    while (n != null) {
                        if (n.getOpcode() == Opcodes.LDC && ((LdcInsnNode) n).cst.equals(40000)) {
                            break;
                        }
                        n = n.getNext();
                    }
                    if (n != null) {
                        mn.instructions.set(n, new LdcInsnNode(10000));
                    }
                }
            }
            ClassWriter cw = new ClassWriter(0);
            cn.accept(cw);
            return cw.toByteArray();
        } else if (name.equals("ic2.core.block.wiring.TileEntityChargepadBatBox")){
            ClassReader cr = new ClassReader(bytes);
            ClassNode cn = new ClassNode();
            cr.accept(cn, 0);
            for (MethodNode mn : cn.methods) {
                if (mn.name.equals("<init>")) {
                    AbstractInsnNode n = mn.instructions.getFirst();
                    while (n != null) {
                        if (n.getOpcode() == Opcodes.LDC && ((LdcInsnNode) n).cst.equals(40000)) {
                            break;
                        }
                        n = n.getNext();
                    }
                    if (n != null) {
                        mn.instructions.set(n, new LdcInsnNode(10000));
                    }
                }
            }
            ClassWriter cw = new ClassWriter(0);
            cn.accept(cw);
            return cw.toByteArray();
        } else if (name.equals("ic2.core.block.wiring.TileEntityElectricCESU")){
            ClassReader cr = new ClassReader(bytes);
            ClassNode cn = new ClassNode();
            cr.accept(cn, 0);
            for (MethodNode mn : cn.methods) {
                if (mn.name.equals("<init>")) {
                    AbstractInsnNode n = mn.instructions.getFirst();
                    while (n != null) {
                        if (n.getOpcode() == Opcodes.LDC && ((LdcInsnNode) n).cst.equals(300000)) {
                            break;
                        }
                        n = n.getNext();
                    }
                    if (n != null) {
                        mn.instructions.set(n, new LdcInsnNode(75000));
                    }
                }
            }
            ClassWriter cw = new ClassWriter(0);
            cn.accept(cw);
            return cw.toByteArray();
        } else if (name.equals("ic2.core.block.wiring.TileEntityChargepadCESU")){
            ClassReader cr = new ClassReader(bytes);
            ClassNode cn = new ClassNode();
            cr.accept(cn, 0);
            for (MethodNode mn : cn.methods) {
                if (mn.name.equals("<init>")) {
                    AbstractInsnNode n = mn.instructions.getFirst();
                    while (n != null) {
                        if (n.getOpcode() == Opcodes.LDC && ((LdcInsnNode) n).cst.equals(300000)) {
                            break;
                        }
                        n = n.getNext();
                    }
                    if (n != null) {
                        mn.instructions.set(n, new LdcInsnNode(75000));
                    }
                }
            }
            ClassWriter cw = new ClassWriter(0);
            cn.accept(cw);
            return cw.toByteArray();
        } else if (name.equals("ic2.core.block.wiring.TileEntityElectricMFE")){
            ClassReader cr = new ClassReader(bytes);
            ClassNode cn = new ClassNode();
            cr.accept(cn, 0);
            for (MethodNode mn : cn.methods) {
                if (mn.name.equals("<init>")) {
                    AbstractInsnNode n = mn.instructions.getFirst();
                    while (n != null) {
                        if (n.getOpcode() == Opcodes.LDC && ((LdcInsnNode) n).cst.equals(4000000)) {
                            break;
                        }
                        n = n.getNext();
                    }
                    if (n != null) {
                        mn.instructions.set(n, new LdcInsnNode(600000));
                    }
                }
            }
            ClassWriter cw = new ClassWriter(0);
            cn.accept(cw);
            return cw.toByteArray();
        } else if (name.equals("ic2.core.block.wiring.TileEntityChargepadMFE")){
            ClassReader cr = new ClassReader(bytes);
            ClassNode cn = new ClassNode();
            cr.accept(cn, 0);
            for (MethodNode mn : cn.methods) {
                if (mn.name.equals("<init>")) {
                    AbstractInsnNode n = mn.instructions.getFirst();
                    while (n != null) {
                        if (n.getOpcode() == Opcodes.LDC && ((LdcInsnNode) n).cst.equals(4000000)) {
                            break;
                        }
                        n = n.getNext();
                    }
                    if (n != null) {
                        mn.instructions.set(n, new LdcInsnNode(600000));
                    }
                }
            }
            ClassWriter cw = new ClassWriter(0);
            cn.accept(cw);
            return cw.toByteArray();
        } else if (name.equals("ic2.core.block.wiring.TileEntityElectricMFSU")){
            ClassReader cr = new ClassReader(bytes);
            ClassNode cn = new ClassNode();
            cr.accept(cn, 0);
            for (MethodNode mn : cn.methods) {
                if (mn.name.equals("<init>")) {
                    AbstractInsnNode n = mn.instructions.getFirst();
                    while (n != null) {
                        if (n.getOpcode() == Opcodes.LDC && ((LdcInsnNode) n).cst.equals(40000000)) {
                            break;
                        }
                        n = n.getNext();
                    }
                    if (n != null) {
                        mn.instructions.set(n, new LdcInsnNode(5000000));
                    }
                }
            }
            ClassWriter cw = new ClassWriter(0);
            cn.accept(cw);
            return cw.toByteArray();
        } else if (name.equals("ic2.core.block.wiring.TileEntityChargepadMFSU")){
            ClassReader cr = new ClassReader(bytes);
            ClassNode cn = new ClassNode();
            cr.accept(cn, 0);
            for (MethodNode mn : cn.methods) {
                if (mn.name.equals("<init>")) {
                    AbstractInsnNode n = mn.instructions.getFirst();
                    while (n != null) {
                        if (n.getOpcode() == Opcodes.LDC && ((LdcInsnNode) n).cst.equals(40000000)) {
                            break;
                        }
                        n = n.getNext();
                    }
                    if (n != null) {
                        mn.instructions.set(n, new LdcInsnNode(5000000));
                    }
                }
            }
            ClassWriter cw = new ClassWriter(0);
            cn.accept(cw);
            return cw.toByteArray();
        } else if (name.equals("ic2.core.init.BlocksItems")){
            ClassReader cr = new ClassReader(bytes);
            ClassNode cn = new ClassNode();
            cr.accept(cn, 0);
            for (MethodNode mn : cn.methods) {
                if (mn.name.equals("initItems")) {
                    AbstractInsnNode n = mn.instructions.getFirst();
                    AbstractInsnNode n1 = null;
                    AbstractInsnNode n2 = null;
                    AbstractInsnNode n3 = null;
                    AbstractInsnNode n4 = null;
                    AbstractInsnNode n5 = null;
                    AbstractInsnNode n6 = null;
                    AbstractInsnNode n7 = null;
                    while (n != null) {
                        if (n.getOpcode() == Opcodes.LDC && ((LdcInsnNode) n).cst.equals(10000.0D)) {
                            n1 = n;
                        } else if (n.getOpcode() == Opcodes.LDC && ((LdcInsnNode) n).cst.equals(100000.0D)) {
                            n2 = n;
                        } else if (n.getOpcode() == Opcodes.LDC && ((LdcInsnNode) n).cst.equals(1000000.0D)) {
                            n3 = n;
                        } else if (n.getOpcode() == Opcodes.LDC && ((LdcInsnNode) n).cst.equals(1.0E7D)) {
                            n4 = n;
                        } else if (n.getOpcode() == Opcodes.LDC && ((LdcInsnNode) n).cst.equals(40000.0D)) {
                            n5 = n;
                        } else if (n.getOpcode() == Opcodes.LDC && ((LdcInsnNode) n).cst.equals(400000.0D)) {
                            n6 = n;
                        } else if (n.getOpcode() == Opcodes.LDC && ((LdcInsnNode) n).cst.equals(4000000.0D)) {
                            n7 = n;
                        } else if (n.getOpcode() == Opcodes.LDC && ((LdcInsnNode) n).cst.equals(4.0E7D)) {
                            break;
                        }
                        n = n.getNext();
                    }
                    if (n != null) {
                        mn.instructions.set(n1, new LdcInsnNode(4000.0D));
                        mn.instructions.set(n2, new LdcInsnNode(25000.0D));
                        mn.instructions.set(n3, new LdcInsnNode(150000.0D));
                        mn.instructions.set(n4, new LdcInsnNode(1250000.0D));
                        mn.instructions.set(n5, new LdcInsnNode(10000.0D));
                        mn.instructions.set(n6, new LdcInsnNode(75000.0D));
                        mn.instructions.set(n7, new LdcInsnNode(600000.0D));
                        mn.instructions.set(n, new LdcInsnNode(5000000.0D));
                    }
                }
            }
            ClassWriter cw = new ClassWriter(0);
            cn.accept(cw);
            return cw.toByteArray();
        } else {
            return bytes;
        }
    }
}
