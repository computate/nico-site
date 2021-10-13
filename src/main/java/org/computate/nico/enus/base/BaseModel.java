package org.computate.nico.enus.base;                     

import java.text.Normalizer;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.commons.lang3.reflect.FieldUtils;

import org.computate.nico.enus.config.ConfigKeys;
import org.computate.nico.enus.request.SiteRequestEnUS;
import org.computate.nico.enus.wrap.Wrap;

/**
 * Indexed: true
 * Page: true
 * SuperPage: PageLayout
 * 
 * Keyword: classSimpleNameCluster
 */              
public class BaseModel extends BaseModelGen<Object> {

	/**
	 * {@inheritDoc}
	 * Ignore: true
	 */
	protected void _siteRequest_(Wrap<SiteRequestEnUS> w) {}

	/**
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 * PrimaryKey: true
	 * Modify: false
	 * HtmlRow: 1
	 * HtmlCell: 1
	 * DisplayName.enUS: primary key
	 */ 
	protected void _pk(Wrap<Long> w) {}

	/**
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 * InheritPrimaryKey: true
	 * Define: true
	 */
	protected void _inheritPk(Wrap<String> w) {}

	/**
	 * {@inheritDoc}
	 * UniqueKey: true
	 */
	protected void _id(Wrap<String> w) {
		if(pk != null)
			w.o(getClass().getSimpleName() + "_" + pk.toString());
	}

	/**
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 * Define: true
	 * Modify: false
	 * VarCreated: true
	 * HtmlRow: 1
	 * HtmlCell: 2
	 * HtmlColumn: 2
	 * DisplayName.enUS: created
	 */
	protected void _created(Wrap<ZonedDateTime> w) {}

	/**
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 * Modify: false
	 * VarModified: true
	 * HtmlRow: 1
	 * HtmlCell: 3
	 * DisplayName.enUS: modified
	 */   
	protected void _modified(Wrap<ZonedDateTime> w) {
		w.o(ZonedDateTime.now(ZoneId.of(siteRequest_.getConfig().getString(ConfigKeys.SITE_ZONE))));
	}

	/**
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 * Define: true
	 * HtmlRow: 2
	 * HtmlCell: 1
	 * DisplayName.enUS: archived
	 */ 
	protected void _archived(Wrap<Boolean> w) {
		w.o(false);
	}

	/**
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 * Define: true
	 * HtmlRow: 2
	 * HtmlCell: 2
	 * DisplayName.enUS: deleted
	 */ 
	protected void _deleted(Wrap<Boolean> w) {
		w.o(false);
	}

	/**
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 */ 
	protected void _classCanonicalName(Wrap<String> w) {
		w.o(getClass().getCanonicalName());
	}

	/**
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 */ 
	protected void _classSimpleName(Wrap<String> w) {
		w.o(getClass().getSimpleName());
	}

	/**
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 */ 
	protected void _classCanonicalNames(List<String> l) { 
		Class<?> cl = getClass();
		if(!cl.equals(BaseModel.class))
			l.add(cl.getCanonicalName());
		l.add(BaseModel.class.getCanonicalName());
	}

	/**
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 * Define: true
	 * Modify: false
	 */  
	protected void _sessionId(Wrap<String> c) {
	}

	/**   
	 * {@inheritDoc}
	 * Var.enUS: userKey
	 * Indexed: true
	 * Stored: true
	 * Define: true
	 * Modify: false
	 */                 
	protected void _userKey(Wrap<Long> c) {
	}
	/**
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 * Saves: true
	 */ 
	protected void _saves(List<String> l) {
	}

	/**
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 * VarTitle: true
	 * HtmlColumn: 2
	 */ 
	protected void _objectTitle(Wrap<String> w) {
		if(pk != null)
			w.o(pk.toString());
	}

	/**
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 * VarId: true
	 * HtmlRow: 1
	 * HtmlCell: 4
	 * DisplayName.enUS: ID
	 */ 
	protected void _objectId(Wrap<String> c) {
		if(objectTitle != null) {
			c.o(toId(objectTitle));
		}
		else if(pk != null){
			c.o(pk.toString());
		}
	}

	public String toId(String s) {
		if(s != null) {
			s = Normalizer.normalize(s, Normalizer.Form.NFD);
			s = StringUtils.lowerCase(s);
			s = StringUtils.trim(s);
			s = StringUtils.replacePattern(s, "\\s{1,}", "-");
			s = StringUtils.replacePattern(s, "[^\\w-]", "");
			s = StringUtils.replacePattern(s, "-{2,}", "-");
		}

		return s;
	}

	protected void _objectNameVar(Wrap<String> c) {
		if(objectId != null) {
			Class<?> cl = getClass();

			try {
				String o = toId(StringUtils.join(StringUtils.splitByCharacterTypeCamelCase((String)FieldUtils.getField(cl, cl.getSimpleName() + "_NameVar").get(this)), "-"));
				c.o(o);
			} catch (Exception e) {
				ExceptionUtils.rethrow(e);
			}
		}
	}

	/**
	 * {@inheritDoc}
	 * Suggested: true
	 */    
	protected void _objectSuggest(Wrap<String> c) { 
		StringBuilder b = new StringBuilder();
		if(pk != null)
			b.append(" ").append(pk);
		if(objectNameVar != null)
			b.append(" ").append(objectNameVar);
		if(objectId != null)
			b.append(" ").append(objectId);
		if(objectTitle != null)
			b.append(" ").append(objectTitle);
		c.o(b.toString());
	}

	/**
	 * {@inheritDoc}
	 * Text: true
	 */       
	protected void _objectText(Wrap<String> c) { 
		StringBuilder b = new StringBuilder();
		if(pk != null)
			b.append(" ").append(pk);
		if(objectNameVar != null)
			b.append(" ").append(objectNameVar);
		if(objectId != null)
			b.append(" ").append(objectId);
		if(objectTitle != null)
			b.append(" ").append(objectTitle);
		c.o(b.toString());
	}

	/**
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 * VarUrlId: true
	 */ 
	protected void _pageUrlId(Wrap<String> c) {
		if(objectId != null) {
			String o = siteRequest_.getConfig().getString(ConfigKeys.SITE_BASE_URL) + "/" + objectNameVar + "/" + objectId;
			c.o(o);
		}
	}

	/**
	 * {@inheritDoc}
	 * Indexed: true
	 * Stored: true
	 * VarUrlPk: true
	 */ 
	protected void _pageUrlPk(Wrap<String> c) {
		if(pk != null) {
			String o = siteRequest_.getConfig().getString(ConfigKeys.SITE_BASE_URL) + "/" + objectNameVar + "/" + pk;
			c.o(o);
		}
	}

	/**	
	 * {@inheritDoc}
	 * Indexe: true
	 * Stocke: true
	 **/   
	protected void _pageUrlApi(Wrap<String> c)  {
		if(pk != null) {
			String o = siteRequest_.getConfig().getString(ConfigKeys.SITE_BASE_URL) + "/api/" + objectNameVar + "/" + pk;
			c.o(o);
		}
	}

	/**
	 * {@inheritDoc}
	 * H1: true
	 */ 
	protected void _pageH1(Wrap<String> c) {
		try {
			Class<?> cl = getClass();
			c.o((String)FieldUtils.getField(cl, cl.getSimpleName() + "_NameSingular").get(this) + ": " + objectTitle);
		} catch (Exception e) {
			ExceptionUtils.rethrow(e);
		}
	}
}
