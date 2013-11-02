package com.gwang.techforum4;

import org.drools.KnowledgeBase;
import org.drools.KnowledgeBaseFactory;
import org.drools.builder.KnowledgeBuilder;
import org.drools.builder.KnowledgeBuilderError;
import org.drools.builder.KnowledgeBuilderErrors;
import org.drools.builder.KnowledgeBuilderFactory;
import org.drools.builder.ResourceType;
import org.drools.io.ResourceFactory;
import org.drools.io.Resource;
import org.drools.logger.KnowledgeRuntimeLogger;
import org.drools.logger.KnowledgeRuntimeLoggerFactory;
import org.drools.runtime.StatefulKnowledgeSession;

import com.gwang.techforum4.models.Person;
import com.gwang.techforum4.models.IsFather;

/**
 * Created with IntelliJ IDEA.
 * User: gwang2
 * Date: 11/1/13
 * Time: 9:28 PM
 * To change this template use File | Settings | File Templates.
 */
public class CandyTest {

    public static final void main(String[] args) {
        try {
            // load up the knowledge base
            KnowledgeBase kbase = readKnowledgeNase();
            StatefulKnowledgeSession ksession = kbase.newStatefulKnowledgeSession();
            KnowledgeRuntimeLogger logger = KnowledgeRuntimeLoggerFactory.newFileLogger(ksession, "test");

            // adding facts
            Person p1 = new Person("Paul", 65, 10);
            System.out.println("Fact: " + p1.getName() + " is a Person");
            Person p2 = new Person("Peter", 35, 5);
            System.out.println("Fact: " + p2.getName() + " is a Person");
            Person p3 = new Person("Parker", 5, 0);
            System.out.println("Fact: " + p3.getName() + " is a Person");

            IsFather isf1 = new IsFather(p1, p2);
            System.out.println("Fact: " + p1.getName() + " is the father of " + p2.getName());
            IsFather isf2 = new IsFather(p2, p3);
            System.out.println("Fact: " + p2.getName() + " is the father of " + p3.getName());

            ksession.insert(p1);
            ksession.insert(p2);
            ksession.insert(p3);
            ksession.insert(isf1);
            ksession.insert(isf2);

            System.out.println("-----------------------------------------------------------------");
            ksession.fireAllRules();
            logger.close();
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }

    private static KnowledgeBase readKnowledgeNase() throws Exception {
        KnowledgeBuilder kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
        //kbuilder.add(ResourceFactory.newClassPathResource("candy.drl"), ResourceType.DRL);
        kbuilder.add(ResourceFactory.newFileResource("src/com/gwang/techforum4/rules/candy.drl"), ResourceType.DRL);
        KnowledgeBuilderErrors errors = kbuilder.getErrors();
        if (errors.size() > 0 ) {
            for (KnowledgeBuilderError error : errors ) {
                System.err.println(error);
            }
            throw new IllegalArgumentException("Could not parse knowledge base!");
        }
        KnowledgeBase kbase = KnowledgeBaseFactory.newKnowledgeBase();
        kbase.addKnowledgePackages(kbuilder.getKnowledgePackages());
        return kbase;
    }
}
