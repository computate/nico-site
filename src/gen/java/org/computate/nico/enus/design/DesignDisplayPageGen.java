package org.computate.nico.enus.design;

import java.util.Arrays;
import org.computate.nico.enus.design.DesignDisplayGenPage;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import org.computate.nico.enus.html.part.HtmlPart;
import java.util.HashMap;
import org.apache.commons.lang3.StringUtils;
import org.computate.nico.enus.writer.AllWriter;
import java.text.NumberFormat;
import io.vertx.core.logging.LoggerFactory;
import java.util.ArrayList;
import org.computate.nico.enus.request.SiteRequestEnUS;
import org.apache.commons.collections.CollectionUtils;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import java.util.Map;
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
import org.computate.nico.enus.enrollment.SiteEnrollment;
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

	public String sqlPageDesignId() {
		return pageDesignId;
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

	///////////
	// stuff //
	///////////

	/**	 The entity stuff
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut Map<String, Object>(). 
	 */
	@JsonInclude(Include.NON_NULL)
	protected Map<String, Object> stuff = new HashMap<String, Object>();
	@JsonIgnore
	public Wrap<Map<String, Object>> stuffWrap = new Wrap<Map<String, Object>>().p(this).c(Map.class).var("stuff").o(stuff);

	/**	<br/> The entity stuff
	 *  It is constructed before being initialized with the constructor by default Map<String, Object>(). 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.nico.enus.design.DesignDisplayPage&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:stuff">Find the entity stuff in Solr</a>
	 * <br/>
	 * @param stuff is the entity already constructed. 
	 **/
	protected abstract void _stuff(Map<String, Object> m);

	public Map<String, Object> getStuff() {
		return stuff;
	}

	public void setStuff(Map<String, Object> stuff) {
		this.stuff = stuff;
		this.stuffWrap.alreadyInitialized = true;
	}
	public static Map<String, Object> staticSetStuff(SiteRequestEnUS siteRequest_, String o) {
		return null;
	}
	protected DesignDisplayPage stuffInit() {
		if(!stuffWrap.alreadyInitialized) {
			_stuff(stuff);
		}
		stuffWrap.alreadyInitialized(true);
		return (DesignDisplayPage)this;
	}

	//////////////////////
	// enrollmentSearch //
	//////////////////////

	/**	 The entity enrollmentSearch
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut SearchList<SiteEnrollment>(). 
	 */
	@JsonInclude(Include.NON_NULL)
	protected SearchList<SiteEnrollment> enrollmentSearch = new SearchList<SiteEnrollment>();
	@JsonIgnore
	public Wrap<SearchList<SiteEnrollment>> enrollmentSearchWrap = new Wrap<SearchList<SiteEnrollment>>().p(this).c(SearchList.class).var("enrollmentSearch").o(enrollmentSearch);

	/**	<br/> The entity enrollmentSearch
	 *  It is constructed before being initialized with the constructor by default SearchList<SiteEnrollment>(). 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.nico.enus.design.DesignDisplayPage&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:enrollmentSearch">Find the entity enrollmentSearch in Solr</a>
	 * <br/>
	 * @param enrollmentSearch is the entity already constructed. 
	 **/
	protected abstract void _enrollmentSearch(SearchList<SiteEnrollment> l);

	public SearchList<SiteEnrollment> getEnrollmentSearch() {
		return enrollmentSearch;
	}

	public void setEnrollmentSearch(SearchList<SiteEnrollment> enrollmentSearch) {
		this.enrollmentSearch = enrollmentSearch;
		this.enrollmentSearchWrap.alreadyInitialized = true;
	}
	public static SearchList<SiteEnrollment> staticSetEnrollmentSearch(SiteRequestEnUS siteRequest_, String o) {
		return null;
	}
	protected DesignDisplayPage enrollmentSearchInit() {
		if(!enrollmentSearchWrap.alreadyInitialized) {
			_enrollmentSearch(enrollmentSearch);
		}
		enrollmentSearch.initDeepForClass(siteRequest_);
		enrollmentSearchWrap.alreadyInitialized(true);
		return (DesignDisplayPage)this;
	}

	////////////////////
	// siteEnrollment //
	////////////////////

	/**	 The entity siteEnrollment
	 *	 is defined as null before being initialized. 
	 */
	@JsonInclude(Include.NON_NULL)
	protected SiteEnrollment siteEnrollment;
	@JsonIgnore
	public Wrap<SiteEnrollment> siteEnrollmentWrap = new Wrap<SiteEnrollment>().p(this).c(SiteEnrollment.class).var("siteEnrollment").o(siteEnrollment);

	/**	<br/> The entity siteEnrollment
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.nico.enus.design.DesignDisplayPage&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:siteEnrollment">Find the entity siteEnrollment in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _siteEnrollment(Wrap<SiteEnrollment> c);

	public SiteEnrollment getSiteEnrollment() {
		return siteEnrollment;
	}

	public void setSiteEnrollment(SiteEnrollment siteEnrollment) {
		this.siteEnrollment = siteEnrollment;
		this.siteEnrollmentWrap.alreadyInitialized = true;
	}
	public static SiteEnrollment staticSetSiteEnrollment(SiteRequestEnUS siteRequest_, String o) {
		return null;
	}
	protected DesignDisplayPage siteEnrollmentInit() {
		if(!siteEnrollmentWrap.alreadyInitialized) {
			_siteEnrollment(siteEnrollmentWrap);
			if(siteEnrollment == null)
				setSiteEnrollment(siteEnrollmentWrap.o);
		}
		if(siteEnrollment != null)
			siteEnrollment.initDeepForClass(siteRequest_);
		siteEnrollmentWrap.alreadyInitialized(true);
		return (DesignDisplayPage)this;
	}

	/////////////////
	// enrollments //
	/////////////////

	/**	 The entity enrollments
	 *	 is defined as null before being initialized. 
	 */
	@JsonInclude(Include.NON_NULL)
	protected List<SiteEnrollment> enrollments;
	@JsonIgnore
	public Wrap<List<SiteEnrollment>> enrollmentsWrap = new Wrap<List<SiteEnrollment>>().p(this).c(List.class).var("enrollments").o(enrollments);

	/**	<br/> The entity enrollments
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.nico.enus.design.DesignDisplayPage&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:enrollments">Find the entity enrollments in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _enrollments(Wrap<List<SiteEnrollment>> c);

	public List<SiteEnrollment> getEnrollments() {
		return enrollments;
	}

	public void setEnrollments(List<SiteEnrollment> enrollments) {
		this.enrollments = enrollments;
		this.enrollmentsWrap.alreadyInitialized = true;
	}
	public static SiteEnrollment staticSetEnrollments(SiteRequestEnUS siteRequest_, String o) {
		return null;
	}
	public DesignDisplayPage addEnrollments(SiteEnrollment...objets) {
		for(SiteEnrollment o : objets) {
			addEnrollments(o);
		}
		return (DesignDisplayPage)this;
	}
	public DesignDisplayPage addEnrollments(SiteEnrollment o) {
		if(o != null && !enrollments.contains(o))
			this.enrollments.add(o);
		return (DesignDisplayPage)this;
	}
	protected DesignDisplayPage enrollmentsInit() {
		if(!enrollmentsWrap.alreadyInitialized) {
			_enrollments(enrollmentsWrap);
			if(enrollments == null)
				setEnrollments(enrollmentsWrap.o);
		}
		enrollmentsWrap.alreadyInitialized(true);
		return (DesignDisplayPage)this;
	}

	///////////////
	// emailFrom //
	///////////////

	/**	 The entity emailFrom
	 *	 is defined as null before being initialized. 
	 */
	@JsonInclude(Include.NON_NULL)
	protected String emailFrom;
	@JsonIgnore
	public Wrap<String> emailFromWrap = new Wrap<String>().p(this).c(String.class).var("emailFrom").o(emailFrom);

	/**	<br/> The entity emailFrom
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.nico.enus.design.DesignDisplayPage&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:emailFrom">Find the entity emailFrom in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _emailFrom(Wrap<String> c);

	public String getEmailFrom() {
		return emailFrom;
	}
	public void setEmailFrom(String o) {
		this.emailFrom = DesignDisplayPage.staticSetEmailFrom(siteRequest_, o);
		this.emailFromWrap.alreadyInitialized = true;
	}
	public static String staticSetEmailFrom(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	protected DesignDisplayPage emailFromInit() {
		if(!emailFromWrap.alreadyInitialized) {
			_emailFrom(emailFromWrap);
			if(emailFrom == null)
				setEmailFrom(emailFromWrap.o);
		}
		emailFromWrap.alreadyInitialized(true);
		return (DesignDisplayPage)this;
	}

	public static String staticSolrEmailFrom(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSolrStrEmailFrom(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqEmailFrom(SiteRequestEnUS siteRequest_, String o) {
		return DesignDisplayPage.staticSolrStrEmailFrom(siteRequest_, DesignDisplayPage.staticSolrEmailFrom(siteRequest_, DesignDisplayPage.staticSetEmailFrom(siteRequest_, o)));
	}

	public String solrEmailFrom() {
		return DesignDisplayPage.staticSolrEmailFrom(siteRequest_, emailFrom);
	}

	public String strEmailFrom() {
		return emailFrom == null ? "" : emailFrom;
	}

	public String sqlEmailFrom() {
		return emailFrom;
	}

	public String jsonEmailFrom() {
		return emailFrom == null ? "" : emailFrom;
	}

	public String nomAffichageEmailFrom() {
		return null;
	}

	public String htmTooltipEmailFrom() {
		return null;
	}

	public String htmEmailFrom() {
		return emailFrom == null ? "" : StringEscapeUtils.escapeHtml4(strEmailFrom());
	}

	///////////////////
	// emailToSchool //
	///////////////////

	/**	 The entity emailToSchool
	 *	 is defined as null before being initialized. 
	 */
	@JsonInclude(Include.NON_NULL)
	protected String emailToSchool;
	@JsonIgnore
	public Wrap<String> emailToSchoolWrap = new Wrap<String>().p(this).c(String.class).var("emailToSchool").o(emailToSchool);

	/**	<br/> The entity emailToSchool
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.nico.enus.design.DesignDisplayPage&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:emailToSchool">Find the entity emailToSchool in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _emailToSchool(Wrap<String> c);

	public String getEmailToSchool() {
		return emailToSchool;
	}
	public void setEmailToSchool(String o) {
		this.emailToSchool = DesignDisplayPage.staticSetEmailToSchool(siteRequest_, o);
		this.emailToSchoolWrap.alreadyInitialized = true;
	}
	public static String staticSetEmailToSchool(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	protected DesignDisplayPage emailToSchoolInit() {
		if(!emailToSchoolWrap.alreadyInitialized) {
			_emailToSchool(emailToSchoolWrap);
			if(emailToSchool == null)
				setEmailToSchool(emailToSchoolWrap.o);
		}
		emailToSchoolWrap.alreadyInitialized(true);
		return (DesignDisplayPage)this;
	}

	public static String staticSolrEmailToSchool(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSolrStrEmailToSchool(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqEmailToSchool(SiteRequestEnUS siteRequest_, String o) {
		return DesignDisplayPage.staticSolrStrEmailToSchool(siteRequest_, DesignDisplayPage.staticSolrEmailToSchool(siteRequest_, DesignDisplayPage.staticSetEmailToSchool(siteRequest_, o)));
	}

	public String solrEmailToSchool() {
		return DesignDisplayPage.staticSolrEmailToSchool(siteRequest_, emailToSchool);
	}

	public String strEmailToSchool() {
		return emailToSchool == null ? "" : emailToSchool;
	}

	public String sqlEmailToSchool() {
		return emailToSchool;
	}

	public String jsonEmailToSchool() {
		return emailToSchool == null ? "" : emailToSchool;
	}

	public String nomAffichageEmailToSchool() {
		return null;
	}

	public String htmTooltipEmailToSchool() {
		return null;
	}

	public String htmEmailToSchool() {
		return emailToSchool == null ? "" : StringEscapeUtils.escapeHtml4(strEmailToSchool());
	}

	////////////////////
	// emailToAddress //
	////////////////////

	/**	 The entity emailToAddress
	 *	 is defined as null before being initialized. 
	 */
	@JsonInclude(Include.NON_NULL)
	protected String emailToAddress;
	@JsonIgnore
	public Wrap<String> emailToAddressWrap = new Wrap<String>().p(this).c(String.class).var("emailToAddress").o(emailToAddress);

	/**	<br/> The entity emailToAddress
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.nico.enus.design.DesignDisplayPage&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:emailToAddress">Find the entity emailToAddress in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _emailToAddress(Wrap<String> c);

	public String getEmailToAddress() {
		return emailToAddress;
	}
	public void setEmailToAddress(String o) {
		this.emailToAddress = DesignDisplayPage.staticSetEmailToAddress(siteRequest_, o);
		this.emailToAddressWrap.alreadyInitialized = true;
	}
	public static String staticSetEmailToAddress(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	protected DesignDisplayPage emailToAddressInit() {
		if(!emailToAddressWrap.alreadyInitialized) {
			_emailToAddress(emailToAddressWrap);
			if(emailToAddress == null)
				setEmailToAddress(emailToAddressWrap.o);
		}
		emailToAddressWrap.alreadyInitialized(true);
		return (DesignDisplayPage)this;
	}

	public static String staticSolrEmailToAddress(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSolrStrEmailToAddress(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqEmailToAddress(SiteRequestEnUS siteRequest_, String o) {
		return DesignDisplayPage.staticSolrStrEmailToAddress(siteRequest_, DesignDisplayPage.staticSolrEmailToAddress(siteRequest_, DesignDisplayPage.staticSetEmailToAddress(siteRequest_, o)));
	}

	public String solrEmailToAddress() {
		return DesignDisplayPage.staticSolrEmailToAddress(siteRequest_, emailToAddress);
	}

	public String strEmailToAddress() {
		return emailToAddress == null ? "" : emailToAddress;
	}

	public String sqlEmailToAddress() {
		return emailToAddress;
	}

	public String jsonEmailToAddress() {
		return emailToAddress == null ? "" : emailToAddress;
	}

	public String nomAffichageEmailToAddress() {
		return null;
	}

	public String htmTooltipEmailToAddress() {
		return null;
	}

	public String htmEmailToAddress() {
		return emailToAddress == null ? "" : StringEscapeUtils.escapeHtml4(strEmailToAddress());
	}

	/////////////////
	// emailToName //
	/////////////////

	/**	 The entity emailToName
	 *	 is defined as null before being initialized. 
	 */
	@JsonInclude(Include.NON_NULL)
	protected String emailToName;
	@JsonIgnore
	public Wrap<String> emailToNameWrap = new Wrap<String>().p(this).c(String.class).var("emailToName").o(emailToName);

	/**	<br/> The entity emailToName
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.nico.enus.design.DesignDisplayPage&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:emailToName">Find the entity emailToName in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _emailToName(Wrap<String> c);

	public String getEmailToName() {
		return emailToName;
	}
	public void setEmailToName(String o) {
		this.emailToName = DesignDisplayPage.staticSetEmailToName(siteRequest_, o);
		this.emailToNameWrap.alreadyInitialized = true;
	}
	public static String staticSetEmailToName(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	protected DesignDisplayPage emailToNameInit() {
		if(!emailToNameWrap.alreadyInitialized) {
			_emailToName(emailToNameWrap);
			if(emailToName == null)
				setEmailToName(emailToNameWrap.o);
		}
		emailToNameWrap.alreadyInitialized(true);
		return (DesignDisplayPage)this;
	}

	public static String staticSolrEmailToName(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSolrStrEmailToName(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqEmailToName(SiteRequestEnUS siteRequest_, String o) {
		return DesignDisplayPage.staticSolrStrEmailToName(siteRequest_, DesignDisplayPage.staticSolrEmailToName(siteRequest_, DesignDisplayPage.staticSetEmailToName(siteRequest_, o)));
	}

	public String solrEmailToName() {
		return DesignDisplayPage.staticSolrEmailToName(siteRequest_, emailToName);
	}

	public String strEmailToName() {
		return emailToName == null ? "" : emailToName;
	}

	public String sqlEmailToName() {
		return emailToName;
	}

	public String jsonEmailToName() {
		return emailToName == null ? "" : emailToName;
	}

	public String nomAffichageEmailToName() {
		return null;
	}

	public String htmTooltipEmailToName() {
		return null;
	}

	public String htmEmailToName() {
		return emailToName == null ? "" : StringEscapeUtils.escapeHtml4(strEmailToName());
	}

	//////////////////
	// emailMessage //
	//////////////////

	/**	 The entity emailMessage
	 *	 is defined as null before being initialized. 
	 */
	@JsonInclude(Include.NON_NULL)
	protected String emailMessage;
	@JsonIgnore
	public Wrap<String> emailMessageWrap = new Wrap<String>().p(this).c(String.class).var("emailMessage").o(emailMessage);

	/**	<br/> The entity emailMessage
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.nico.enus.design.DesignDisplayPage&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:emailMessage">Find the entity emailMessage in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _emailMessage(Wrap<String> c);

	public String getEmailMessage() {
		return emailMessage;
	}
	public void setEmailMessage(String o) {
		this.emailMessage = DesignDisplayPage.staticSetEmailMessage(siteRequest_, o);
		this.emailMessageWrap.alreadyInitialized = true;
	}
	public static String staticSetEmailMessage(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	protected DesignDisplayPage emailMessageInit() {
		if(!emailMessageWrap.alreadyInitialized) {
			_emailMessage(emailMessageWrap);
			if(emailMessage == null)
				setEmailMessage(emailMessageWrap.o);
		}
		emailMessageWrap.alreadyInitialized(true);
		return (DesignDisplayPage)this;
	}

	public static String staticSolrEmailMessage(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSolrStrEmailMessage(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqEmailMessage(SiteRequestEnUS siteRequest_, String o) {
		return DesignDisplayPage.staticSolrStrEmailMessage(siteRequest_, DesignDisplayPage.staticSolrEmailMessage(siteRequest_, DesignDisplayPage.staticSetEmailMessage(siteRequest_, o)));
	}

	public String solrEmailMessage() {
		return DesignDisplayPage.staticSolrEmailMessage(siteRequest_, emailMessage);
	}

	public String strEmailMessage() {
		return emailMessage == null ? "" : emailMessage;
	}

	public String sqlEmailMessage() {
		return emailMessage;
	}

	public String jsonEmailMessage() {
		return emailMessage == null ? "" : emailMessage;
	}

	public String nomAffichageEmailMessage() {
		return null;
	}

	public String htmTooltipEmailMessage() {
		return null;
	}

	public String htmEmailMessage() {
		return emailMessage == null ? "" : StringEscapeUtils.escapeHtml4(strEmailMessage());
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

	/////////////////
	// requestVars //
	/////////////////

	/**	 The entity requestVars
	 *	 is defined as null before being initialized. 
	 */
	@JsonInclude(Include.NON_NULL)
	protected Map<String, String> requestVars;
	@JsonIgnore
	public Wrap<Map<String, String>> requestVarsWrap = new Wrap<Map<String, String>>().p(this).c(Map.class).var("requestVars").o(requestVars);

	/**	<br/> The entity requestVars
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.nico.enus.design.DesignDisplayPage&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:requestVars">Find the entity requestVars in Solr</a>
	 * <br/>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _requestVars(Wrap<Map<String, String>> w);

	public Map<String, String> getRequestVars() {
		return requestVars;
	}

	public void setRequestVars(Map<String, String> requestVars) {
		this.requestVars = requestVars;
		this.requestVarsWrap.alreadyInitialized = true;
	}
	public static Map<String, String> staticSetRequestVars(SiteRequestEnUS siteRequest_, String o) {
		return null;
	}
	protected DesignDisplayPage requestVarsInit() {
		if(!requestVarsWrap.alreadyInitialized) {
			_requestVars(requestVarsWrap);
			if(requestVars == null)
				setRequestVars(requestVarsWrap.o);
		}
		requestVarsWrap.alreadyInitialized(true);
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
		pageDesignIdInit();
		stuffInit();
		enrollmentSearchInit();
		siteEnrollmentInit();
		enrollmentsInit();
		emailFromInit();
		emailToSchoolInit();
		emailToAddressInit();
		emailToNameInit();
		emailMessageInit();
		htmlPartSearchInit();
		htmlPartListInit();
		requestVarsInit();
	}

	@Override public void initDeepForClass(SiteRequestEnUS siteRequest_) {
		initDeepDesignDisplayPage(siteRequest_);
	}

	/////////////////
	// siteRequest //
	/////////////////

	public void siteRequestDesignDisplayPage(SiteRequestEnUS siteRequest_) {
			super.siteRequestDesignDisplayGenPage(siteRequest_);
		if(enrollmentSearch != null)
			enrollmentSearch.setSiteRequest_(siteRequest_);
		if(siteEnrollment != null)
			siteEnrollment.setSiteRequest_(siteRequest_);
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
			else if(o instanceof Map) {
				Map<?, ?> map = (Map<?, ?>)o;
				o = map.get(v);
			}
		}
		return o;
	}
	public Object obtainDesignDisplayPage(String var) {
		DesignDisplayPage oDesignDisplayPage = (DesignDisplayPage)this;
		switch(var) {
			case "pageDesignId":
				return oDesignDisplayPage.pageDesignId;
			case "stuff":
				return oDesignDisplayPage.stuff;
			case "enrollmentSearch":
				return oDesignDisplayPage.enrollmentSearch;
			case "siteEnrollment":
				return oDesignDisplayPage.siteEnrollment;
			case "enrollments":
				return oDesignDisplayPage.enrollments;
			case "emailFrom":
				return oDesignDisplayPage.emailFrom;
			case "emailToSchool":
				return oDesignDisplayPage.emailToSchool;
			case "emailToAddress":
				return oDesignDisplayPage.emailToAddress;
			case "emailToName":
				return oDesignDisplayPage.emailToName;
			case "emailMessage":
				return oDesignDisplayPage.emailMessage;
			case "htmlPartSearch":
				return oDesignDisplayPage.htmlPartSearch;
			case "htmlPartList":
				return oDesignDisplayPage.htmlPartList;
			case "requestVars":
				return oDesignDisplayPage.requestVars;
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
		case "emailFrom":
			return DesignDisplayPage.staticSetEmailFrom(siteRequest_, o);
		case "emailToSchool":
			return DesignDisplayPage.staticSetEmailToSchool(siteRequest_, o);
		case "emailToAddress":
			return DesignDisplayPage.staticSetEmailToAddress(siteRequest_, o);
		case "emailToName":
			return DesignDisplayPage.staticSetEmailToName(siteRequest_, o);
		case "emailMessage":
			return DesignDisplayPage.staticSetEmailMessage(siteRequest_, o);
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
		case "emailFrom":
			return DesignDisplayPage.staticSolrEmailFrom(siteRequest_, (String)o);
		case "emailToSchool":
			return DesignDisplayPage.staticSolrEmailToSchool(siteRequest_, (String)o);
		case "emailToAddress":
			return DesignDisplayPage.staticSolrEmailToAddress(siteRequest_, (String)o);
		case "emailToName":
			return DesignDisplayPage.staticSolrEmailToName(siteRequest_, (String)o);
		case "emailMessage":
			return DesignDisplayPage.staticSolrEmailMessage(siteRequest_, (String)o);
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
		case "emailFrom":
			return DesignDisplayPage.staticSolrStrEmailFrom(siteRequest_, (String)o);
		case "emailToSchool":
			return DesignDisplayPage.staticSolrStrEmailToSchool(siteRequest_, (String)o);
		case "emailToAddress":
			return DesignDisplayPage.staticSolrStrEmailToAddress(siteRequest_, (String)o);
		case "emailToName":
			return DesignDisplayPage.staticSolrStrEmailToName(siteRequest_, (String)o);
		case "emailMessage":
			return DesignDisplayPage.staticSolrStrEmailMessage(siteRequest_, (String)o);
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
		case "emailFrom":
			return DesignDisplayPage.staticSolrFqEmailFrom(siteRequest_, o);
		case "emailToSchool":
			return DesignDisplayPage.staticSolrFqEmailToSchool(siteRequest_, o);
		case "emailToAddress":
			return DesignDisplayPage.staticSolrFqEmailToAddress(siteRequest_, o);
		case "emailToName":
			return DesignDisplayPage.staticSolrFqEmailToName(siteRequest_, o);
		case "emailMessage":
			return DesignDisplayPage.staticSolrFqEmailMessage(siteRequest_, o);
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
		switch(var.toLowerCase()) {
			default:
				return super.defineDesignDisplayGenPage(var, val);
		}
	}

	@Override public boolean defineForClass(String var, Object val) {
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
	public Object defineDesignDisplayPage(String var, Object val) {
		switch(var.toLowerCase()) {
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
