package com.gordon.framework.controller;

import org.testng.IResultMap;
import org.testng.ISuite;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.xml.XmlTest;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Set;

public class BettytestContext implements ITestContext {

    ISuite suit = new BerrySuit();

    public ISuite getSuit() {
        return suit;
    }

    public void setSuit(ISuite suit) {
        this.suit = suit;
    }

    public BettytestContext() {
    }
    public  String getOutputDirectory(){
        try {
            return this.getClass().getResource("/").getPath()+"../../test-outpist/defaulSuit";
        }catch (Exception e){
            return  null;
        }
    }
    @Override
    public String getName() {
        return null;
    }

    @Override
    public Date getStartDate() {
        return null;
    }

    @Override
    public Date getEndDate() {
        return null;
    }

    @Override
    public IResultMap getPassedTests() {
        return null;
    }

    @Override
    public IResultMap getSkippedTests() {
        return null;
    }

    @Override
    public IResultMap getFailedButWithinSuccessPercentageTests() {
        return null;
    }

    @Override
    public IResultMap getFailedTests() {
        return null;
    }

    @Override
    public String[] getIncludedGroups() {
        return new String[0];
    }

    @Override
    public String[] getExcludedGroups() {
        return new String[0];
    }



    @Override
    public ISuite getSuite() {
        return null;
    }

    @Override
    public ITestNGMethod[] getAllTestMethods() {
        return new ITestNGMethod[0];
    }

    @Override
    public String getHost() {
        return null;
    }

    @Override
    public Collection<ITestNGMethod> getExcludedMethods() {
        return null;
    }

    @Override
    public IResultMap getPassedConfigurations() {
        return null;
    }

    @Override
    public IResultMap getSkippedConfigurations() {
        return null;
    }

    @Override
    public IResultMap getFailedConfigurations() {
        return null;
    }

    @Override
    public XmlTest getCurrentXmlTest() {
        return null;
    }

    @Override
    public List<com.google.inject.Module> getGuiceModules(Class<? extends com.google.inject.Module> aClass) {
        return null;
    }

    @Override
    public void addGuiceModule(Class<? extends com.google.inject.Module> aClass, com.google.inject.Module module) {

    }

    @Override
    public com.google.inject.Injector getInjector(List<com.google.inject.Module> list) {
        return null;
    }

    @Override
    public void addInjector(List<com.google.inject.Module> list, com.google.inject.Injector injector) {

    }

    @Override
    public Object getAttribute(String s) {
        return null;
    }

    @Override
    public void setAttribute(String s, Object o) {

    }

    @Override
    public Set<String> getAttributeNames() {
        return null;
    }

    @Override
    public Object removeAttribute(String s) {
        return null;
    }
}
