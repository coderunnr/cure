package com.example.root.curemedical.Models;

/**
 * Created by root on 6/5/16.
 */
public class OrthopaedicsModel {
    String category,description,media,name,packagename,procedure,result,risks,when;
    int generalward;
    int privateward;
    int semiprivate;
    int maxprivateward;
    int mingeneralward;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    int id;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMedia() {
        return media;
    }

    public void setMedia(String media) {
        this.media = media;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPackagename() {
        return packagename;
    }

    public void setPackagename(String packagename) {
        this.packagename = packagename;
    }

    public String getProcedure() {
        return procedure;
    }

    public void setProcedure(String procedure) {
        this.procedure = procedure;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getRisks() {
        return risks;
    }

    public void setRisks(String risks) {
        this.risks = risks;
    }

    public String getWhen() {
        return when;
    }

    public void setWhen(String when) {
        this.when = when;
    }

    public int getGeneralward() {
        return generalward;
    }

    public void setGeneralward(int generalward) {
        this.generalward = generalward;
    }

    public int getPrivateward() {
        return privateward;
    }

    public void setPrivateward(int privateward) {
        this.privateward = privateward;
    }

    public int getSemiprivate() {
        return semiprivate;
    }

    public void setSemiprivate(int semiprivate) {
        this.semiprivate = semiprivate;
    }

    public int getMaxprivateward() {
        return maxprivateward;
    }

    public void setMaxprivateward(int maxprivateward) {
        this.maxprivateward = maxprivateward;
    }

    public int getMingeneralward() {
        return mingeneralward;
    }

    public void setMingeneralward(int mingeneralward) {
        this.mingeneralward = mingeneralward;
    }
}
