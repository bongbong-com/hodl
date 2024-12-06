package com.bongbong.hodl.templates;

public final class PluginInfo {

	public static final String ID = "${plugin.id}";
	public static final String NAME = "${plugin.name}";
	public static final String VERSION = "${plugin.version};${plugin.commit}";
	public static final String AUTHOR = "${plugin.author}";
	public static final String DESCRIPTION = "${plugin.description}";
	public static final String URL = "${plugin.url}";

	private PluginInfo() {}

}