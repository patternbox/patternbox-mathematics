package com.patternbox.mathematics.web.bean;

import java.util.Locale;

import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 * Change application locale.
 * 
 * @author <a href='http://www.patternbox.com'>D. Ehms, Patternbox</a>
 */
@Named("localeChanger")
@SessionScoped
public class LocaleChangerBean {

	public String englishAction() {
		FacesContext context = FacesContext.getCurrentInstance();
		context.getViewRoot().setLocale(Locale.ENGLISH);
		System.out.println("Language set to English.");
		return null;
	}

	public String germanAction() {
		FacesContext context = FacesContext.getCurrentInstance();
		context.getViewRoot().setLocale(Locale.GERMAN);
		System.out.println("Language set to German.");
		return null;
	}
}
