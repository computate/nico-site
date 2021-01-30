package org.computate.nico.enus.design;

import java.util.Arrays;
import org.computate.nico.enus.design.DesignDisplayGenPage;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import org.computate.nico.enus.html.part.HtmlPart;
import java.util.HashMap;
import org.computate.nico.enus.design.PageDesign;
import org.apache.commons.lang3.StringUtils;
import org.computate.nico.enus.writer.AllWriter;
import java.text.NumberFormat;
import io.vertx.core.logging.LoggerFactory;
import java.util.ArrayList;
import org.computate.nico.enus.request.SiteRequestEnUS;
import org.apache.commons.collections.CollectionUtils;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.lang.String;
import io.vertx.core.logging.Logger;
import org.computate.nico.enus.wrap.Wrap;
import java.math.RoundingMode;
import org.computate.nico.enus.cluster.Cluster;
import java.math.MathContext;
import org.apache.commons.text.StringEscapeUtils;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.computate.nico.enus.request.api.ApiRequest;
import org.computate.nico.enus.search.SearchList;
import java.util.Objects;
import io.vertx.core.json.JsonArray;
import java.util.List;
import org.apache.commons.lang3.math.NumberUtils;
import java.util.Optional;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;

/**	
 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstClasse_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.nico.enus.design.DesignDisplayPage&fq=classeEtendGen_indexed_boolean:true">Find the class  in Solr. </a>
 * <br/>
 **/
public abstract class DesignDisplayPageGen<DEV> extends DesignDisplayGenPage {
	protected static final Logger LOGGER = LoggerFactory.getLogger(DesignDisplayPage.class);

	////////////////
	// pageDesign //
	////////////////

	/**	 The entity pageDesign
	 *	 is defined as null before being initialized. 
	 */
	@JsonInclude(Include.NON_NULL)
	protected PageDesign pageDesign;
	@JsonIgnore
	public Wrap<PageDesign> pageDesignWrap = new Wrap<PageDesign>().p(this).c(PageDesign.class).var("pageDesign").o(pageDesign);

	/**	<br/> The entity pageDesign
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.nico.enus.design.DesignDisplayPage&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:pageDesign">Find the entity pageDesign in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _pageDesign(Wrap<PageDesign> c);

	public PageDesign getPageDesign() {
		return pageDesign;
	}

	public void setPageDesign(PageDesign pageDesign) {
		this.pageDesign = pageDesign;
		this.pageDesignWrap.alreadyInitialized = true;
	}
	public static PageDesign staticSetPageDesign(SiteRequestEnUS siteRequest_, String o) {
		return null;
	}
	protected DesignDisplayPage pageDesignInit() {
		if(!pageDesignWrap.alreadyInitialized) {
			_pageDesign(pageDesignWrap);
			if(pageDesign == null)
				setPageDesign(pageDesignWrap.o);
		}
		if(pageDesign != null)
			pageDesign.initDeepForClass(siteRequest_);
		pageDesignWrap.alreadyInitialized(true);
		return (DesignDisplayPage)this;
	}

	//////////////////
	// pageDesignId //
	//////////////////

	/**	 The entity pageDesignId
	 *	 is defined as null before being initialized. 
	 */
	@JsonInclude(Include.NON_NULL)
	protected String pageDesignId;
	@JsonIgnore
	public Wrap<String> pageDesignIdWrap = new Wrap<String>().p(this).c(String.class).var("pageDesignId").o(pageDesignId);

	/**	<br/> The entity pageDesignId
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.nico.enus.design.DesignDisplayPage&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:pageDesignId">Find the entity pageDesignId in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _pageDesignId(Wrap<String> c);

	public String getPageDesignId() {
		return pageDesignId;
	}
	public void setPageDesignId(String o) {
		this.pageDesignId = DesignDisplayPage.staticSetPageDesignId(siteRequest_, o);
		this.pageDesignIdWrap.alreadyInitialized = true;
	}
	public static String staticSetPageDesignId(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	protected DesignDisplayPage pageDesignIdInit() {
		if(!pageDesignIdWrap.alreadyInitialized) {
			_pageDesignId(pageDesignIdWrap);
			if(pageDesignId == null)
				setPageDesignId(pageDesignIdWrap.o);
		}
		pageDesignIdWrap.alreadyInitialized(true);
		return (DesignDisplayPage)this;
	}

	public static String staticSolrPageDesignId(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSolrStrPageDesignId(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqPageDesignId(SiteRequestEnUS siteRequest_, String o) {
		return DesignDisplayPage.staticSolrStrPageDesignId(siteRequest_, DesignDisplayPage.staticSolrPageDesignId(siteRequest_, DesignDisplayPage.staticSetPageDesignId(siteRequest_, o)));
	}

	public String solrPageDesignId() {
		return DesignDisplayPage.staticSolrPageDesignId(siteRequest_, pageDesignId);
	}

	public String strPageDesignId() {
		return pageDesignId == null ? "" : pageDesignId;
	}

	public String jsonPageDesignId() {
		return pageDesignId == null ? "" : pageDesignId;
	}

	public String nomAffichagePageDesignId() {
		return null;
	}

	public String htmTooltipPageDesignId() {
		return null;
	}

	public String htmPageDesignId() {
		return pageDesignId == null ? "" : StringEscapeUtils.escapeHtml4(strPageDesignId());
	}

	////////////////////
	// htmlPartSearch //
	////////////////////

	/**	 The entity htmlPartSearch
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut SearchList<HtmlPart>(). 
	 */
	@JsonInclude(Include.NON_NULL)
	protected SearchList<HtmlPart> htmlPartSearch = new SearchList<HtmlPart>();
	@JsonIgnore
	public Wrap<SearchList<HtmlPart>> htmlPartSearchWrap = new Wrap<SearchList<HtmlPart>>().p(this).c(SearchList.class).var("htmlPartSearch").o(htmlPartSearch);

	/**	<br/> The entity htmlPartSearch
	 *  It is constructed before being initialized with the constructor by default SearchList<HtmlPart>(). 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.nico.enus.design.DesignDisplayPage&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:htmlPartSearch">Find the entity htmlPartSearch in Solr</a>
	 * <br/>
	 * @param htmlPartSearch is the entity already constructed. 
	 **/
	protected abstract void _htmlPartSearch(SearchList<HtmlPart> l);

	public SearchList<HtmlPart> getHtmlPartSearch() {
		return htmlPartSearch;
	}

	public void setHtmlPartSearch(SearchList<HtmlPart> htmlPartSearch) {
		this.htmlPartSearch = htmlPartSearch;
		this.htmlPartSearchWrap.alreadyInitialized = true;
	}
	public static SearchList<HtmlPart> staticSetHtmlPartSearch(SiteRequestEnUS siteRequest_, String o) {
		return null;
	}
	protected DesignDisplayPage htmlPartSearchInit() {
		if(!htmlPartSearchWrap.alreadyInitialized) {
			_htmlPartSearch(htmlPartSearch);
		}
		htmlPartSearch.initDeepForClass(siteRequest_);
		htmlPartSearchWrap.alreadyInitialized(true);
		return (DesignDisplayPage)this;
	}

	//////////////////
	// htmlPartList //
	//////////////////

	/**	 The entity htmlPartList
	 *	 is defined as null before being initialized. 
	 */
	@JsonInclude(Include.NON_NULL)
	protected List<HtmlPart> htmlPartList;
	@JsonIgnore
	public Wrap<List<HtmlPart>> htmlPartListWrap = new Wrap<List<HtmlPart>>().p(this).c(List.class).var("htmlPartList").o(htmlPartList);

	/**	<br/> The entity htmlPartList
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.nico.enus.design.DesignDisplayPage&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:htmlPartList">Find the entity htmlPartList in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _htmlPartList(Wrap<List<HtmlPart>> c);

	public List<HtmlPart> getHtmlPartList() {
		return htmlPartList;
	}

	public void setHtmlPartList(List<HtmlPart> htmlPartList) {
		this.htmlPartList = htmlPartList;
		this.htmlPartListWrap.alreadyInitialized = true;
	}
	public static HtmlPart staticSetHtmlPartList(SiteRequestEnUS siteRequest_, String o) {
		return null;
	}
	public DesignDisplayPage addHtmlPartList(HtmlPart...objets) {
		for(HtmlPart o : objets) {
			addHtmlPartList(o);
		}
		return (DesignDisplayPage)this;
	}
	public DesignDisplayPage addHtmlPartList(HtmlPart o) {
		if(o != null && !htmlPartList.contains(o))
			this.htmlPartList.add(o);
		return (DesignDisplayPage)this;
	}
	protected DesignDisplayPage htmlPartListInit() {
		if(!htmlPartListWrap.alreadyInitialized) {
			_htmlPartList(htmlPartListWrap);
			if(htmlPartList == null)
				setHtmlPartList(htmlPartListWrap.o);
		}
		htmlPartListWrap.alreadyInitialized(true);
		return (DesignDisplayPage)this;
	}

	//////////////
	// initDeep //
	//////////////

	protected boolean alreadyInitializedDesignDisplayPage = false;

	public DesignDisplayPage initDeepDesignDisplayPage(SiteRequestEnUS siteRequest_) {
		setSiteRequest_(siteRequest_);
		if(!alreadyInitializedDesignDisplayPage) {
			alreadyInitializedDesignDisplayPage = true;
			initDeepDesignDisplayPage();
		}
		return (DesignDisplayPage)this;
	}

	public void initDeepDesignDisplayPage() {
		initDesignDisplayPage();
		super.initDeepDesignDisplayGenPage(siteRequest_);
	}

	public void initDesignDisplayPage() {
		pageDesignInit();
		pageDesignIdInit();
		htmlPartSearchInit();
		htmlPartListInit();
	}

	@Override public void initDeepForClass(SiteRequestEnUS siteRequest_) {
		initDeepDesignDisplayPage(siteRequest_);
	}

	/////////////////
	// siteRequest //
	/////////////////

	public void siteRequestDesignDisplayPage(SiteRequestEnUS siteRequest_) {
			super.siteRequestDesignDisplayGenPage(siteRequest_);
		if(pageDesign != null)
			pageDesign.setSiteRequest_(siteRequest_);
		if(htmlPartSearch != null)
			htmlPartSearch.setSiteRequest_(siteRequest_);
	}

	public void siteRequestForClass(SiteRequestEnUS siteRequest_) {
		siteRequestDesignDisplayPage(siteRequest_);
	}

	/////////////
	// obtain //
	/////////////

	@Override public Object obtainForClass(String var) {
		String[] vars = StringUtils.split(var, ".");
		Object o = null;
		for(String v : vars) {
			if(o == null)
				o = obtainDesignDisplayPage(v);
			else if(o instanceof Cluster) {
				Cluster cluster = (Cluster)o;
				o = cluster.obtainForClass(v);
			}
		}
		return o;
	}
	public Object obtainDesignDisplayPage(String var) {
		DesignDisplayPage oDesignDisplayPage = (DesignDisplayPage)this;
		switch(var) {
			case "pageDesign":
				return oDesignDisplayPage.pageDesign;
			case "pageDesignId":
				return oDesignDisplayPage.pageDesignId;
			case "htmlPartSearch":
				return oDesignDisplayPage.htmlPartSearch;
			case "htmlPartList":
				return oDesignDisplayPage.htmlPartList;
			default:
				return super.obtainDesignDisplayGenPage(var);
		}
	}

	///////////////
	// attribute //
	///////////////

	@Override public boolean attributeForClass(String var, Object val) {
		String[] vars = StringUtils.split(var, ".");
		Object o = null;
		for(String v : vars) {
			if(o == null)
				o = attributeDesignDisplayPage(v, val);
			else if(o instanceof Cluster) {
				Cluster cluster = (Cluster)o;
				o = cluster.attributeForClass(v, val);
			}
		}
		return o != null;
	}
	public Object attributeDesignDisplayPage(String var, Object val) {
		DesignDisplayPage oDesignDisplayPage = (DesignDisplayPage)this;
		switch(var) {
			default:
				return super.attributeDesignDisplayGenPage(var, val);
		}
	}

	///////////////
	// staticSet //
	///////////////

	public static Object staticSetForClass(String entityVar, SiteRequestEnUS siteRequest_, String o) {
		return staticSetDesignDisplayPage(entityVar,  siteRequest_, o);
	}
	public static Object staticSetDesignDisplayPage(String entityVar, SiteRequestEnUS siteRequest_, String o) {
		switch(entityVar) {
		case "pageDesignId":
			return DesignDisplayPage.staticSetPageDesignId(siteRequest_, o);
			default:
				return DesignDisplayGenPage.staticSetDesignDisplayGenPage(entityVar,  siteRequest_, o);
		}
	}

	////////////////
	// staticSolr //
	////////////////

	public static Object staticSolrForClass(String entityVar, SiteRequestEnUS siteRequest_, Object o) {
		return staticSolrDesignDisplayPage(entityVar,  siteRequest_, o);
	}
	public static Object staticSolrDesignDisplayPage(String entityVar, SiteRequestEnUS siteRequest_, Object o) {
		switch(entityVar) {
		case "pageDesignId":
			return DesignDisplayPage.staticSolrPageDesignId(siteRequest_, (String)o);
			default:
				return DesignDisplayGenPage.staticSolrDesignDisplayGenPage(entityVar,  siteRequest_, o);
		}
	}

	///////////////////
	// staticSolrStr //
	///////////////////

	public static String staticSolrStrForClass(String entityVar, SiteRequestEnUS siteRequest_, Object o) {
		return staticSolrStrDesignDisplayPage(entityVar,  siteRequest_, o);
	}
	public static String staticSolrStrDesignDisplayPage(String entityVar, SiteRequestEnUS siteRequest_, Object o) {
		switch(entityVar) {
		case "pageDesignId":
			return DesignDisplayPage.staticSolrStrPageDesignId(siteRequest_, (String)o);
			default:
				return DesignDisplayGenPage.staticSolrStrDesignDisplayGenPage(entityVar,  siteRequest_, o);
		}
	}

	//////////////////
	// staticSolrFq //
	//////////////////

	public static String staticSolrFqForClass(String entityVar, SiteRequestEnUS siteRequest_, String o) {
		return staticSolrFqDesignDisplayPage(entityVar,  siteRequest_, o);
	}
	public static String staticSolrFqDesignDisplayPage(String entityVar, SiteRequestEnUS siteRequest_, String o) {
		switch(entityVar) {
		case "pageDesignId":
			return DesignDisplayPage.staticSolrFqPageDesignId(siteRequest_, o);
			default:
				return DesignDisplayGenPage.staticSolrFqDesignDisplayGenPage(entityVar,  siteRequest_, o);
		}
	}

	/////////////
	// define //
	/////////////

	@Override public boolean defineForClass(String var, String val) {
		String[] vars = StringUtils.split(var, ".");
		Object o = null;
		if(val != null) {
			for(String v : vars) {
				if(o == null)
					o = defineDesignDisplayPage(v, val);
				else if(o instanceof Cluster) {
					Cluster oCluster = (Cluster)o;
					o = oCluster.defineForClass(v, val);
				}
			}
		}
		return o != null;
	}
	public Object defineDesignDisplayPage(String var, String val) {
		switch(var) {
			default:
				return super.defineDesignDisplayGenPage(var, val);
		}
	}

	/////////////////
	// htmlScripts //
	/////////////////

	@Override public void htmlScripts() {
		htmlScriptsDesignDisplayPage();
		super.htmlScripts();
	}

	public void htmlScriptsDesignDisplayPage() {
	}

	////////////////
	// htmlScript //
	////////////////

	@Override public void htmlScript() {
		htmlScriptDesignDisplayPage();
		super.htmlScript();
	}

	public void htmlScriptDesignDisplayPage() {
	}

	//////////////
	// htmlBody //
	//////////////

	@Override public void htmlBody() {
		htmlBodyDesignDisplayPage();
		super.htmlBody();
	}

	public void htmlBodyDesignDisplayPage() {
	}

	//////////
	// html //
	//////////

	@Override public void html() {
		htmlDesignDisplayPage();
		super.html();
	}

	public void htmlDesignDisplayPage() {
	}

	//////////////
	// htmlMeta //
	//////////////

	@Override public void htmlMeta() {
		htmlMetaDesignDisplayPage();
		super.htmlMeta();
	}

	public void htmlMetaDesignDisplayPage() {
	}

	////////////////
	// htmlStyles //
	////////////////

	@Override public void htmlStyles() {
		htmlStylesDesignDisplayPage();
		super.htmlStyles();
	}

	public void htmlStylesDesignDisplayPage() {
	}

	///////////////
	// htmlStyle //
	///////////////

	@Override public void htmlStyle() {
		htmlStyleDesignDisplayPage();
		super.htmlStyle();
	}

	public void htmlStyleDesignDisplayPage() {
	}

	//////////////////
	// apiRequest //
	//////////////////

	public void apiRequestDesignDisplayPage() {
		ApiRequest apiRequest = Optional.ofNullable(siteRequest_).map(SiteRequestEnUS::getApiRequest_).orElse(null);
		Object o = Optional.ofNullable(apiRequest).map(ApiRequest::getOriginal).orElse(null);
		if(o != null && o instanceof DesignDisplayPage) {
			DesignDisplayPage original = (DesignDisplayPage)o;
			super.apiRequestDesignDisplayGenPage();
		}
	}

	//////////////
	// hashCode //
	//////////////

	@Override public int hashCode() {
		return Objects.hash(super.hashCode());
	}

	////////////
	// equals //
	////////////

	@Override public boolean equals(Object o) {
		if(this == o)
			return true;
		if(!(o instanceof DesignDisplayPage))
			return false;
		DesignDisplayPage that = (DesignDisplayPage)o;
		return super.equals(o);
	}

	//////////////
	// toString //
	//////////////

	@Override public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString() + "\n");
		sb.append("DesignDisplayPage { ");
		sb.append(" }");
		return sb.toString();
	}
}