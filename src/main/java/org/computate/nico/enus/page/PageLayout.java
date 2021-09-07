package org.computate.nico.enus.page;

import org.computate.nico.enus.request.SiteRequestEnUS;
import org.computate.nico.enus.wrap.Wrap;

import io.vertx.core.Promise;
import io.vertx.core.json.JsonObject;

/**
 * Keyword: classSimpleNamePageLayout
 **/
public class PageLayout extends PageLayoutGen<Object> {

	/**
	 * Ignore: true
	**/
	protected void _siteRequest_(Wrap<SiteRequestEnUS> c) {
	}

	/**
	 * Ignore: true
	**/
	protected void _promiseBefore(Promise<Void> promise) {
		promise.complete();
	}

	protected void _pageH1(Wrap<String> c) {
			c.o("pets");
	}

	protected void _pageH2(Wrap<String> c) {
		c.o("");
	}

	protected void _pageH3(Wrap<String> c) {
		c.o("");
	}

	protected void _pageTitle(Wrap<String> c) {
	}

	protected void _pageUri(Wrap<String> c) {
	}

	protected void _pagination(JsonObject pagination) {
	}

	protected void _query(JsonObject query) {
	}

	/**
	 * Ignore: true
	**/
	protected void _promiseAfter(Promise<Void> promise) {
		promise.complete();
	}

	protected void _pageImageUri(Wrap<String> c) {
	}

	protected void _contextIconGroup(Wrap<String> c) {
	}

	protected void _contextIconName(Wrap<String> c) {
	}
}
