package org.computate.nico.enus.wrap;

import java.io.Serializable;

/**
 * Keyword: classSimpleNameWrap
 **/
public class Wrap<DEV> implements Serializable {

	public String var;

	public Wrap<DEV> var(String o) {
		var = o;
		return this;
	}

	public DEV o;

	public Wrap<DEV> o(DEV o) {
		this.o = o;
		return this;
	}
}
