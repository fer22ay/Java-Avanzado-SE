package com.fernando.makereport;

/**
 * <h1>Report</h1>
 * Clase reporte
 *
 * @author Fernando Ambrosio
 * @version v0.1.0
 * @since 15 de febrero del 2020
 */
public class Report {

    private String nameFile;
    private String extension;
    private String title;
    private String content;

    public Report() {
    }

    public String getNameFile() {
        return nameFile;
    }

    public void setNameFile(String nameFile) {
        this.nameFile = nameFile;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    
    public void makeReport(){
        
    }
    
}
