package com.amazonaws.auth.policy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class Statement {
    private List<Action> actions = new ArrayList();
    private List<Condition> conditions = new ArrayList();
    private Effect effect;
    private String id;
    private List<Principal> principals = new ArrayList();
    private List<Resource> resources;

    public enum Effect {
        Allow,
        Deny
    }

    public Statement(Effect effect2) {
        this.effect = effect2;
        this.id = null;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String str) {
        this.id = str;
    }

    public Statement withId(String str) {
        setId(str);
        return this;
    }

    public Effect getEffect() {
        return this.effect;
    }

    public void setEffect(Effect effect2) {
        this.effect = effect2;
    }

    public List<Action> getActions() {
        return this.actions;
    }

    public void setActions(Collection<Action> collection) {
        this.actions = new ArrayList(collection);
    }

    public Statement withActions(Action... actionArr) {
        setActions(Arrays.asList(actionArr));
        return this;
    }

    public List<Resource> getResources() {
        return this.resources;
    }

    public void setResources(Collection<Resource> collection) {
        this.resources = new ArrayList(collection);
    }

    public Statement withResources(Resource... resourceArr) {
        setResources(Arrays.asList(resourceArr));
        return this;
    }

    public List<Condition> getConditions() {
        return this.conditions;
    }

    public void setConditions(List<Condition> list) {
        this.conditions = list;
    }

    public Statement withConditions(Condition... conditionArr) {
        setConditions(Arrays.asList(conditionArr));
        return this;
    }

    public List<Principal> getPrincipals() {
        return this.principals;
    }

    public void setPrincipals(Collection<Principal> collection) {
        this.principals = new ArrayList(collection);
    }

    public void setPrincipals(Principal... principalArr) {
        setPrincipals((Collection<Principal>) new ArrayList(Arrays.asList(principalArr)));
    }

    public Statement withPrincipals(Principal... principalArr) {
        setPrincipals(principalArr);
        return this;
    }
}
