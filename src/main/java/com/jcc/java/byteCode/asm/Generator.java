package com.jcc.java.byteCode.asm;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @program: javaknowledge->Generator
 * @description: generator
 * @author: jinchuanchuan1@le.com
 * @create: 2020-03-09 18:17
 **/
public class Generator {
    public static void main(String[] args) throws IOException {
        //读取
        ClassReader classReader = new ClassReader("com/jcc/java/byteCode/asm/Base");
        ClassWriter classWriter = new ClassWriter(ClassWriter.COMPUTE_MAXS);
        //处理
        ClassVisitor classVisitor = new MyClassVisitor(classWriter);
        classReader.accept(classVisitor, ClassReader.SKIP_DEBUG);
        byte[] data = classWriter.toByteArray();
        //输出
        File f = new File("/Users/leeco/Documents/workspace_self/java-summary-knowledge/java-knowledge/target/classes/com/jcc/java/byteCode/asm/Base.class");
        FileOutputStream fout = new FileOutputStream(f);
        fout.write(data);
        fout.close();
        System.out.println("now generator cc success!!!!!");
    }
}
