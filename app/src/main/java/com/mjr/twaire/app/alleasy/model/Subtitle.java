package com.mjr.twaire.app.alleasy.model;

public class Subtitle {
    private CharSequence label;
	private Class<?> activity;

	public Subtitle(CharSequence label, Class<?> activity) {
		this.label = label;
		this.activity = activity;
	}

	public void setLabel(CharSequence label) {
		this.label = label;
	}

	public CharSequence getLabel() {
		return label;
	}

	public void setClassId(Class<?> activity) {
		this.activity = activity;
	}

	public Class<?> getClassId() {
		return activity;
	}
}
