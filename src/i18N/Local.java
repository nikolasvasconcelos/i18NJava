/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package i18N;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 *
 * @author nikolasvasconcelos and FabioDelaRoca
 */
public class Local {
    private ResourceBundle textos;
    private Locale local;
    
    public Local(String lang, String country) {
        this.local = new Locale(lang, country);
        this.textos = ResourceBundle.getBundle("src/i18N/Textos", local);
    }
    
    public Local() {
        this.local = new Locale("pt", "BR");
        this.textos = ResourceBundle.getBundle("src/i18N/Textos", local);
    }

    public void setLocal(String language, String country) {
        this.local = new Locale(language, country);
        this.textos = ResourceBundle.getBundle("src/i18N/Textos", this.local);
    }
    
    public String getLanguage() {
        return this.local.getLanguage();
    }
    
    public ResourceBundle getBundle() {
        return this.textos;
    }
    
}