package com.jcc.pattern.visitorPattern;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @program: javaknowledge->VisitorPattern
 * @description: 访问者模式
 * @author: jinchuanchuan1@le.com
 * @create: 2020-03-07 17:18
 **/
public class VisitorPattern {

    public static void main(String[] args) {
        ObjectStructure os = new ObjectStructure();
        os.add(new ConcreteElementA());
        os.add(new ConcreteElementB());
        Visitor visitor = new ConcreteVisitorA();
        os.accept(visitor);
        System.out.println("------------------------");
        visitor = new ConcreteVisitorB();
        os.accept(visitor);
    }

}

interface Visitor {
    void visit(ConcreteElementA concreteElementA);
    void visit(ConcreteElementB concreteElementB);
}

class ConcreteVisitorA implements Visitor {
    @Override
    public void visit(ConcreteElementA concreteElementA) {
        System.out.println("ConcreteVisitorA操作元素A：" + concreteElementA.operationA());
    }

    @Override
    public void visit(ConcreteElementB concreteElementB) {
        System.out.println("ConcreteVisitorA操作元素B：" + concreteElementB.operationB());
    }
}

class ConcreteVisitorB implements Visitor {
    @Override
    public void visit(ConcreteElementA concreteElementA) {
        System.out.println("ConcreteVisitorB操作元素A：" + concreteElementA.operationA());
    }

    @Override
    public void visit(ConcreteElementB concreteElementB) {
        System.out.println("ConcreteVisitorB操作元素B：" + concreteElementB.operationB());
    }
}

interface Element {
    void accept(Visitor visitor);
}

class ConcreteElementA implements Element {
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public String operationA() {
        return "具体元素A的操作。";
    }
}

class ConcreteElementB implements Element {
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public String operationB() {
        return "具体元素B的操作。";
    }
}

class ObjectStructure {
    private List<Element> list = new ArrayList<Element>();

    public void accept(Visitor visitor)
    {
        Iterator<Element> i = list.iterator();
        while(i.hasNext())
        {
            ((Element) i.next()).accept(visitor);
        }
    }
    public void add(Element element) {
        list.add(element);
    }

    public void remove(Element element) {
        list.remove(element);
    }
}