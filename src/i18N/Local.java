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
 * @author nikolasvasconcelos
 */
public class Local {
    private final Locale local;
    private ResourceBundle texts;
    
    public Local () {
        this.local = new Locale("pt","BR");
        this.texts = ResourceBundle.getBundle("Textos", this.local);
    }
    
    public void setLocale(String language, String country) {
        this.local.setDefault(new Locale(language, country));
        this.texts = ResourceBundle.getBundle("Textos", this.local);
    }
    
    public String getLanguage() {
        return this.local.getLanguage();
    }
    
    

}
