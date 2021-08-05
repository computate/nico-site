package org.computate.nico.enus.enrollment;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Arrays;
import java.util.Date;
import org.slf4j.LoggerFactory;
import org.apache.commons.lang3.StringUtils;
import org.computate.nico.enus.writer.AllWriter;
import java.lang.Long;
import java.util.Map;
import org.computate.nico.enus.user.SiteUser;
import io.vertx.core.json.JsonObject;
import org.computate.nico.enus.base.BaseModel;
import java.math.RoundingMode;
import org.computate.nico.enus.pet.SitePet;
import java.math.MathContext;
import java.util.Set;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.computate.nico.enus.search.SearchList;
import io.vertx.core.Future;
import java.util.Objects;
import java.util.List;
import org.apache.solr.client.solrj.SolrQuery;
import java.util.Optional;
import org.apache.solr.client.solrj.util.ClientUtils;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.apache.solr.common.SolrInputDocument;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.computate.nico.enus.java.ZonedDateTimeSerializer;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import java.util.HashMap;
import org.computate.nico.enus.java.ZonedDateTimeDeserializer;
import java.text.NumberFormat;
import java.util.ArrayList;
import org.computate.nico.enus.request.SiteRequestEnUS;
import org.apache.commons.collections.CollectionUtils;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.lang.String;
import org.computate.nico.enus.wrap.Wrap;
import org.computate.nico.enus.java.LocalDateSerializer;
import org.slf4j.Logger;
import io.vertx.core.Promise;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.commons.text.StringEscapeUtils;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import org.computate.nico.enus.request.api.ApiRequest;
import org.apache.solr.client.solrj.SolrClient;
import io.vertx.core.json.JsonArray;
import org.apache.solr.common.SolrDocument;
import org.apache.commons.lang3.math.NumberUtils;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.computate.nico.enus.config.ConfigKeys;

/**	
 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstClasse_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.nico.enus.enrollment.SiteEnrollment&fq=classeEtendGen_indexed_boolean:true">Find the class  in Solr. </a>
 * <br/>
 **/
public abstract class SiteEnrollmentGen<DEV> extends BaseModel {
	protected static final Logger LOG = LoggerFactory.getLogger(SiteEnrollment.class);

	public static final List<String> ROLES = Arrays.asList("SiteAdmin");
	public static final List<String> ROLE_READS = Arrays.asList("");

	public static final String SiteEnrollment_AName = "an enrollment";
	public static final String SiteEnrollment_This = "this ";
	public static final String SiteEnrollment_ThisName = "this enrollment";
	public static final String SiteEnrollment_A = "a ";
	public static final String SiteEnrollment_TheName = "theenrollment";
	public static final String SiteEnrollment_NameSingular = "enrollment";
	public static final String SiteEnrollment_NamePlural = "enrollments";
	public static final String SiteEnrollment_NameActual = "current enrollment";
	public static final String SiteEnrollment_AllName = "all the enrollments";
	public static final String SiteEnrollment_SearchAllNameBy = "search enrollments by ";
	public static final String SiteEnrollment_Title = "enrollments";
	public static final String SiteEnrollment_ThePluralName = "the enrollments";
	public static final String SiteEnrollment_NoNameFound = "no enrollment found";
	public static final String SiteEnrollment_NameVar = "reportCard";
	public static final String SiteEnrollment_OfName = "of enrollment";
	public static final String SiteEnrollment_ANameAdjective = "an enrollment";
	public static final String SiteEnrollment_NameAdjectiveSingular = "enrollment";
	public static final String SiteEnrollment_NameAdjectivePlural = "enrollments";
	public static final String SiteEnrollment_Color = "red";
	public static final String SiteEnrollment_IconGroup = "duotone";
	public static final String SiteEnrollment_IconName = "clipboard-list";
	public static final Integer SiteEnrollment_Rows = 100;

	///////////////////
	// enrollmentKey //
	///////////////////

	/**	 The entity enrollmentKey
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected Long enrollmentKey;
	@JsonIgnore
	public Wrap<Long> enrollmentKeyWrap = new Wrap<Long>().var("enrollmentKey").o(enrollmentKey);

	/**	<br/> The entity enrollmentKey
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.nico.enus.enrollment.SiteEnrollment&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:enrollmentKey">Find the entity enrollmentKey in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _enrollmentKey(Wrap<Long> c);

	public Long getEnrollmentKey() {
		return enrollmentKey;
	}

	public void setEnrollmentKey(Long enrollmentKey) {
		this.enrollmentKey = enrollmentKey;
		this.enrollmentKeyWrap.alreadyInitialized = true;
	}
	@JsonIgnore
	public void setEnrollmentKey(String o) {
		this.enrollmentKey = SiteEnrollment.staticSetEnrollmentKey(siteRequest_, o);
		this.enrollmentKeyWrap.alreadyInitialized = true;
	}
	public static Long staticSetEnrollmentKey(SiteRequestEnUS siteRequest_, String o) {
		if(NumberUtils.isParsable(o))
			return Long.parseLong(o);
		return null;
	}
	protected SiteEnrollment enrollmentKeyInit() {
		if(!enrollmentKeyWrap.alreadyInitialized) {
			_enrollmentKey(enrollmentKeyWrap);
			if(enrollmentKey == null)
				setEnrollmentKey(enrollmentKeyWrap.o);
			enrollmentKeyWrap.o(null);
		}
		enrollmentKeyWrap.alreadyInitialized(true);
		return (SiteEnrollment)this;
	}

	public static Long staticSolrEnrollmentKey(SiteRequestEnUS siteRequest_, Long o) {
		return o;
	}

	public static String staticSolrStrEnrollmentKey(SiteRequestEnUS siteRequest_, Long o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqEnrollmentKey(SiteRequestEnUS siteRequest_, String o) {
		return SiteEnrollment.staticSolrStrEnrollmentKey(siteRequest_, SiteEnrollment.staticSolrEnrollmentKey(siteRequest_, SiteEnrollment.staticSetEnrollmentKey(siteRequest_, o)));
	}

	public Long solrEnrollmentKey() {
		return SiteEnrollment.staticSolrEnrollmentKey(siteRequest_, enrollmentKey);
	}

	public String strEnrollmentKey() {
		return enrollmentKey == null ? "" : enrollmentKey.toString();
	}

	public Long sqlEnrollmentKey() {
		return enrollmentKey;
	}

	public String jsonEnrollmentKey() {
		return enrollmentKey == null ? "" : enrollmentKey.toString();
	}

	public String htmTooltipEnrollmentKey() {
		return null;
	}

	public String htmEnrollmentKey() {
		return enrollmentKey == null ? "" : StringEscapeUtils.escapeHtml4(strEnrollmentKey());
	}

	//////////////
	// userKeys //
	//////////////

	/**	 The entity userKeys
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut List<Long>(). 
	 */
	@JsonProperty
	@JsonFormat(shape = JsonFormat.Shape.ARRAY)
	@JsonSerialize(contentUsing = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected List<Long> userKeys = new ArrayList<Long>();
	@JsonIgnore
	public Wrap<List<Long>> userKeysWrap = new Wrap<List<Long>>().var("userKeys").o(userKeys);

	/**	<br/> The entity userKeys
	 *  It is constructed before being initialized with the constructor by default List<Long>(). 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.nico.enus.enrollment.SiteEnrollment&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:userKeys">Find the entity userKeys in Solr</a>
	 * <br/>
	 * @param userKeys is the entity already constructed. 
	 **/
	protected abstract void _userKeys(List<Long> c);

	public List<Long> getUserKeys() {
		return userKeys;
	}

	public void setUserKeys(List<Long> userKeys) {
		this.userKeys = userKeys;
		this.userKeysWrap.alreadyInitialized = true;
	}
	@JsonIgnore
	public void setUserKeys(String o) {
		Long l = SiteEnrollment.staticSetUserKeys(siteRequest_, o);
		if(l != null)
			addUserKeys(l);
		this.userKeysWrap.alreadyInitialized = true;
	}
	public static Long staticSetUserKeys(SiteRequestEnUS siteRequest_, String o) {
		if(NumberUtils.isParsable(o))
			return Long.parseLong(o);
		return null;
	}
	public SiteEnrollment addUserKeys(Long...objets) {
		for(Long o : objets) {
			addUserKeys(o);
		}
		return (SiteEnrollment)this;
	}
	public SiteEnrollment addUserKeys(Long o) {
		if(o != null && !userKeys.contains(o))
			this.userKeys.add(o);
		return (SiteEnrollment)this;
	}
	@JsonIgnore
	public void setUserKeys(JsonArray objets) {
		userKeys.clear();
		for(int i = 0; i < objets.size(); i++) {
			Long o = objets.getLong(i);
			addUserKeys(o);
		}
	}
	public SiteEnrollment addUserKeys(String o) {
		if(NumberUtils.isParsable(o)) {
			Long p = Long.parseLong(o);
			addUserKeys(p);
		}
		return (SiteEnrollment)this;
	}
	protected SiteEnrollment userKeysInit() {
		if(!userKeysWrap.alreadyInitialized) {
			_userKeys(userKeys);
		}
		userKeysWrap.alreadyInitialized(true);
		return (SiteEnrollment)this;
	}

	public static Long staticSolrUserKeys(SiteRequestEnUS siteRequest_, Long o) {
		return o;
	}

	public static String staticSolrStrUserKeys(SiteRequestEnUS siteRequest_, Long o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqUserKeys(SiteRequestEnUS siteRequest_, String o) {
		return SiteEnrollment.staticSolrStrUserKeys(siteRequest_, SiteEnrollment.staticSolrUserKeys(siteRequest_, SiteEnrollment.staticSetUserKeys(siteRequest_, o)));
	}

	public List<Long> solrUserKeys() {
		List<Long> l = new ArrayList<Long>();
		for(Long o : userKeys) {
			l.add(SiteEnrollment.staticSolrUserKeys(siteRequest_, o));
		}
		return l;
	}

	public String strUserKeys() {
		return userKeys == null ? "" : userKeys.toString();
	}

	public List<Long> sqlUserKeys() {
		return userKeys;
	}

	public String jsonUserKeys() {
		return userKeys == null ? "" : userKeys.toString();
	}

	public String htmTooltipUserKeys() {
		return null;
	}

	public String htmUserKeys() {
		return userKeys == null ? "" : StringEscapeUtils.escapeHtml4(strUserKeys());
	}

	/////////////
	// petKeys //
	/////////////

	/**	 The entity petKeys
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut List<Long>(). 
	 */
	@JsonProperty
	@JsonFormat(shape = JsonFormat.Shape.ARRAY)
	@JsonSerialize(contentUsing = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected List<Long> petKeys = new ArrayList<Long>();
	@JsonIgnore
	public Wrap<List<Long>> petKeysWrap = new Wrap<List<Long>>().var("petKeys").o(petKeys);

	/**	<br/> The entity petKeys
	 *  It is constructed before being initialized with the constructor by default List<Long>(). 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.nico.enus.enrollment.SiteEnrollment&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:petKeys">Find the entity petKeys in Solr</a>
	 * <br/>
	 * @param petKeys is the entity already constructed. 
	 **/
	protected abstract void _petKeys(List<Long> c);

	public List<Long> getPetKeys() {
		return petKeys;
	}

	public void setPetKeys(List<Long> petKeys) {
		this.petKeys = petKeys;
		this.petKeysWrap.alreadyInitialized = true;
	}
	@JsonIgnore
	public void setPetKeys(String o) {
		Long l = SiteEnrollment.staticSetPetKeys(siteRequest_, o);
		if(l != null)
			addPetKeys(l);
		this.petKeysWrap.alreadyInitialized = true;
	}
	public static Long staticSetPetKeys(SiteRequestEnUS siteRequest_, String o) {
		if(NumberUtils.isParsable(o))
			return Long.parseLong(o);
		return null;
	}
	public SiteEnrollment addPetKeys(Long...objets) {
		for(Long o : objets) {
			addPetKeys(o);
		}
		return (SiteEnrollment)this;
	}
	public SiteEnrollment addPetKeys(Long o) {
		if(o != null && !petKeys.contains(o))
			this.petKeys.add(o);
		return (SiteEnrollment)this;
	}
	@JsonIgnore
	public void setPetKeys(JsonArray objets) {
		petKeys.clear();
		for(int i = 0; i < objets.size(); i++) {
			Long o = objets.getLong(i);
			addPetKeys(o);
		}
	}
	public SiteEnrollment addPetKeys(String o) {
		if(NumberUtils.isParsable(o)) {
			Long p = Long.parseLong(o);
			addPetKeys(p);
		}
		return (SiteEnrollment)this;
	}
	protected SiteEnrollment petKeysInit() {
		if(!petKeysWrap.alreadyInitialized) {
			_petKeys(petKeys);
		}
		petKeysWrap.alreadyInitialized(true);
		return (SiteEnrollment)this;
	}

	public static Long staticSolrPetKeys(SiteRequestEnUS siteRequest_, Long o) {
		return o;
	}

	public static String staticSolrStrPetKeys(SiteRequestEnUS siteRequest_, Long o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqPetKeys(SiteRequestEnUS siteRequest_, String o) {
		return SiteEnrollment.staticSolrStrPetKeys(siteRequest_, SiteEnrollment.staticSolrPetKeys(siteRequest_, SiteEnrollment.staticSetPetKeys(siteRequest_, o)));
	}

	public List<Long> solrPetKeys() {
		List<Long> l = new ArrayList<Long>();
		for(Long o : petKeys) {
			l.add(SiteEnrollment.staticSolrPetKeys(siteRequest_, o));
		}
		return l;
	}

	public String strPetKeys() {
		return petKeys == null ? "" : petKeys.toString();
	}

	public List<Long> sqlPetKeys() {
		return petKeys;
	}

	public String jsonPetKeys() {
		return petKeys == null ? "" : petKeys.toString();
	}

	public String htmTooltipPetKeys() {
		return null;
	}

	public String htmPetKeys() {
		return petKeys == null ? "" : StringEscapeUtils.escapeHtml4(strPetKeys());
	}

	///////////////
	// petSearch //
	///////////////

	/**	 The entity petSearch
	 *	 is defined as null before being initialized. 
	 */
	@JsonIgnore
	@JsonInclude(Include.NON_NULL)
	protected SearchList<SitePet> petSearch;
	@JsonIgnore
	public Wrap<SearchList<SitePet>> petSearchWrap = new Wrap<SearchList<SitePet>>().var("petSearch").o(petSearch);

	/**	<br/> The entity petSearch
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.nico.enus.enrollment.SiteEnrollment&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:petSearch">Find the entity petSearch in Solr</a>
	 * <br/>
	 * @param promise is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _petSearch(Promise<SearchList<SitePet>> promise);

	public SearchList<SitePet> getPetSearch() {
		return petSearch;
	}

	public void setPetSearch(SearchList<SitePet> petSearch) {
		this.petSearch = petSearch;
		this.petSearchWrap.alreadyInitialized = true;
	}
	public static SearchList<SitePet> staticSetPetSearch(SiteRequestEnUS siteRequest_, String o) {
		return null;
	}
	protected Future<SearchList<SitePet>> petSearchPromise() {
		Promise<SearchList<SitePet>> promise = Promise.promise();
		if(!petSearchWrap.alreadyInitialized) {
			Promise<SearchList<SitePet>> promise2 = Promise.promise();
			_petSearch(promise2);
			promise2.future().onSuccess(o -> {
				if(o != null && petSearch == null) {
					o.promiseDeepForClass(siteRequest_).onSuccess(a -> {
						setPetSearch(o);
						petSearchWrap.alreadyInitialized(true);
						promise.complete(o);
					}).onFailure(ex -> {
						promise.fail(ex);
					});
				} else {
					petSearchWrap.alreadyInitialized(true);
					promise.complete(o);
				}
			}).onFailure(ex -> {
				promise.fail(ex);
			});
		} else {
			promise.complete();
		}
		return promise.future();
	}

	//////////
	// pet_ //
	//////////

	/**	 The entity pet_
	 *	 is defined as null before being initialized. 
	 */
	@JsonIgnore
	@JsonInclude(Include.NON_NULL)
	protected SitePet pet_;
	@JsonIgnore
	public Wrap<SitePet> pet_Wrap = new Wrap<SitePet>().var("pet_").o(pet_);

	/**	<br/> The entity pet_
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.nico.enus.enrollment.SiteEnrollment&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:pet_">Find the entity pet_ in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _pet_(Wrap<SitePet> c);

	public SitePet getPet_() {
		return pet_;
	}

	public void setPet_(SitePet pet_) {
		this.pet_ = pet_;
		this.pet_Wrap.alreadyInitialized = true;
	}
	public static SitePet staticSetPet_(SiteRequestEnUS siteRequest_, String o) {
		return null;
	}
	protected SiteEnrollment pet_Init() {
		if(!pet_Wrap.alreadyInitialized) {
			_pet_(pet_Wrap);
			if(pet_ == null)
				setPet_(pet_Wrap.o);
			pet_Wrap.o(null);
		}
		pet_Wrap.alreadyInitialized(true);
		return (SiteEnrollment)this;
	}

	//////////////
	// initDeep //
	//////////////

	protected boolean alreadyInitializedSiteEnrollment = false;

	public Future<Void> promiseDeepSiteEnrollment(SiteRequestEnUS siteRequest_) {
		setSiteRequest_(siteRequest_);
		if(!alreadyInitializedSiteEnrollment) {
			alreadyInitializedSiteEnrollment = true;
			return promiseDeepSiteEnrollment();
		} else {
			return Future.succeededFuture();
		}
	}

	public Future<Void> promiseDeepSiteEnrollment() {
		Promise<Void> promise = Promise.promise();
		Promise<Void> promise2 = Promise.promise();
		promiseSiteEnrollment(promise2);
		promise2.future().onSuccess(a -> {
			super.promiseDeepBaseModel(siteRequest_).onSuccess(b -> {
				promise.complete();
			}).onFailure(ex -> {
				promise.fail(ex);
			});
		}).onFailure(ex -> {
			promise.fail(ex);
		});
		return promise.future();
	}

	public Future<Void> promiseSiteEnrollment(Promise<Void> promise) {
		Future.future(a -> a.complete()).compose(a -> {
			Promise<Void> promise2 = Promise.promise();
			try {
				enrollmentKeyInit();
				userKeysInit();
				petKeysInit();
				promise2.complete();
			} catch(Exception ex) {
				promise2.fail(ex);
			}
			return promise2.future();
		}).compose(a -> {
			Promise<Void> promise2 = Promise.promise();
			petSearchPromise().onSuccess(petSearch -> {
				promise2.complete();
			}).onFailure(ex -> {
				promise2.fail(ex);
			});
			return promise2.future();
		}).compose(a -> {
			Promise<Void> promise2 = Promise.promise();
			try {
				pet_Init();
				promise2.complete();
			} catch(Exception ex) {
				promise2.fail(ex);
			}
			return promise2.future();
		}).onSuccess(a -> {
			promise.complete();
		}).onFailure(ex -> {
			promise.fail(ex);
		});
		return promise.future();
	}

	@Override public Future<Void> promiseDeepForClass(SiteRequestEnUS siteRequest_) {
		return promiseDeepSiteEnrollment(siteRequest_);
	}

	/////////////////
	// siteRequest //
	/////////////////

	public void siteRequestSiteEnrollment(SiteRequestEnUS siteRequest_) {
			super.siteRequestBaseModel(siteRequest_);
		if(petSearch != null)
			petSearch.setSiteRequest_(siteRequest_);
	}

	public void siteRequestForClass(SiteRequestEnUS siteRequest_) {
		siteRequestSiteEnrollment(siteRequest_);
	}

	/////////////
	// obtain //
	/////////////

	@Override public Object obtainForClass(String var) {
		String[] vars = StringUtils.split(var, ".");
		Object o = null;
		for(String v : vars) {
			if(o == null)
				o = obtainSiteEnrollment(v);
			else if(o instanceof BaseModel) {
				BaseModel baseModel = (BaseModel)o;
				o = baseModel.obtainForClass(v);
			}
			else if(o instanceof Map) {
				Map<?, ?> map = (Map<?, ?>)o;
				o = map.get(v);
			}
		}
		return o;
	}
	public Object obtainSiteEnrollment(String var) {
		SiteEnrollment oSiteEnrollment = (SiteEnrollment)this;
		switch(var) {
			case "enrollmentKey":
				return oSiteEnrollment.enrollmentKey;
			case "userKeys":
				return oSiteEnrollment.userKeys;
			case "petKeys":
				return oSiteEnrollment.petKeys;
			case "petSearch":
				return oSiteEnrollment.petSearch;
			case "pet_":
				return oSiteEnrollment.pet_;
			default:
				return super.obtainBaseModel(var);
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
				o = attributeSiteEnrollment(v, val);
			else if(o instanceof BaseModel) {
				BaseModel baseModel = (BaseModel)o;
				o = baseModel.attributeForClass(v, val);
			}
		}
		return o != null;
	}
	public Object attributeSiteEnrollment(String var, Object val) {
		SiteEnrollment oSiteEnrollment = (SiteEnrollment)this;
		switch(var) {
			case "petKeys":
				oSiteEnrollment.addPetKeys((Long)val);
				if(!saves.contains("petKeys"))
					saves.add("petKeys");
				return val;
			default:
				return super.attributeBaseModel(var, val);
		}
	}

	///////////////
	// staticSet //
	///////////////

	public static Object staticSetForClass(String entityVar, SiteRequestEnUS siteRequest_, String o) {
		return staticSetSiteEnrollment(entityVar,  siteRequest_, o);
	}
	public static Object staticSetSiteEnrollment(String entityVar, SiteRequestEnUS siteRequest_, String o) {
		switch(entityVar) {
		case "enrollmentKey":
			return SiteEnrollment.staticSetEnrollmentKey(siteRequest_, o);
		case "userKeys":
			return SiteEnrollment.staticSetUserKeys(siteRequest_, o);
		case "petKeys":
			return SiteEnrollment.staticSetPetKeys(siteRequest_, o);
			default:
				return BaseModel.staticSetBaseModel(entityVar,  siteRequest_, o);
		}
	}

	////////////////
	// staticSolr //
	////////////////

	public static Object staticSolrForClass(String entityVar, SiteRequestEnUS siteRequest_, Object o) {
		return staticSolrSiteEnrollment(entityVar,  siteRequest_, o);
	}
	public static Object staticSolrSiteEnrollment(String entityVar, SiteRequestEnUS siteRequest_, Object o) {
		switch(entityVar) {
		case "enrollmentKey":
			return SiteEnrollment.staticSolrEnrollmentKey(siteRequest_, (Long)o);
		case "userKeys":
			return SiteEnrollment.staticSolrUserKeys(siteRequest_, (Long)o);
		case "petKeys":
			return SiteEnrollment.staticSolrPetKeys(siteRequest_, (Long)o);
			default:
				return BaseModel.staticSolrBaseModel(entityVar,  siteRequest_, o);
		}
	}

	///////////////////
	// staticSolrStr //
	///////////////////

	public static String staticSolrStrForClass(String entityVar, SiteRequestEnUS siteRequest_, Object o) {
		return staticSolrStrSiteEnrollment(entityVar,  siteRequest_, o);
	}
	public static String staticSolrStrSiteEnrollment(String entityVar, SiteRequestEnUS siteRequest_, Object o) {
		switch(entityVar) {
		case "enrollmentKey":
			return SiteEnrollment.staticSolrStrEnrollmentKey(siteRequest_, (Long)o);
		case "userKeys":
			return SiteEnrollment.staticSolrStrUserKeys(siteRequest_, (Long)o);
		case "petKeys":
			return SiteEnrollment.staticSolrStrPetKeys(siteRequest_, (Long)o);
			default:
				return BaseModel.staticSolrStrBaseModel(entityVar,  siteRequest_, o);
		}
	}

	//////////////////
	// staticSolrFq //
	//////////////////

	public static String staticSolrFqForClass(String entityVar, SiteRequestEnUS siteRequest_, String o) {
		return staticSolrFqSiteEnrollment(entityVar,  siteRequest_, o);
	}
	public static String staticSolrFqSiteEnrollment(String entityVar, SiteRequestEnUS siteRequest_, String o) {
		switch(entityVar) {
		case "enrollmentKey":
			return SiteEnrollment.staticSolrFqEnrollmentKey(siteRequest_, o);
		case "userKeys":
			return SiteEnrollment.staticSolrFqUserKeys(siteRequest_, o);
		case "petKeys":
			return SiteEnrollment.staticSolrFqPetKeys(siteRequest_, o);
			default:
				return BaseModel.staticSolrFqBaseModel(entityVar,  siteRequest_, o);
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
					o = defineSiteEnrollment(v, val);
				else if(o instanceof BaseModel) {
					BaseModel oBaseModel = (BaseModel)o;
					o = oBaseModel.defineForClass(v, val);
				}
			}
		}
		return o != null;
	}
	public Object defineSiteEnrollment(String var, String val) {
		switch(var.toLowerCase()) {
			default:
				return super.defineBaseModel(var, val);
		}
	}

	@Override public boolean defineForClass(String var, Object val) {
		String[] vars = StringUtils.split(var, ".");
		Object o = null;
		if(val != null) {
			for(String v : vars) {
				if(o == null)
					o = defineSiteEnrollment(v, val);
				else if(o instanceof BaseModel) {
					BaseModel oBaseModel = (BaseModel)o;
					o = oBaseModel.defineForClass(v, val);
				}
			}
		}
		return o != null;
	}
	public Object defineSiteEnrollment(String var, Object val) {
		switch(var.toLowerCase()) {
			default:
				return super.defineBaseModel(var, val);
		}
	}

	/////////////
	// populate //
	/////////////

	@Override public void populateForClass(SolrDocument solrDocument) {
		populateSiteEnrollment(solrDocument);
	}
	public void populateSiteEnrollment(SolrDocument solrDocument) {
		SiteEnrollment oSiteEnrollment = (SiteEnrollment)this;
		saves = (List<String>)solrDocument.get("saves_stored_strings");
		if(saves != null) {

			if(saves.contains("enrollmentKey")) {
				Long enrollmentKey = (Long)solrDocument.get("enrollmentKey_stored_long");
				if(enrollmentKey != null)
					oSiteEnrollment.setEnrollmentKey(enrollmentKey);
			}

			if(saves.contains("userKeys")) {
				List<Long> userKeys = (List<Long>)solrDocument.get("userKeys_stored_longs");
				if(userKeys != null)
					oSiteEnrollment.userKeys.addAll(userKeys);
			}

			List<Long> petKeys = (List<Long>)solrDocument.get("petKeys_stored_longs");
			if(petKeys != null)
				oSiteEnrollment.petKeys.addAll(petKeys);
		}

		super.populateBaseModel(solrDocument);
	}

	public void indexSiteEnrollment(SolrInputDocument document) {
		if(enrollmentKey != null) {
			document.addField("enrollmentKey_indexed_long", enrollmentKey);
			document.addField("enrollmentKey_stored_long", enrollmentKey);
		}
		if(userKeys != null) {
			for(java.lang.Long o : userKeys) {
				document.addField("userKeys_indexed_longs", o);
			}
			for(java.lang.Long o : userKeys) {
				document.addField("userKeys_stored_longs", o);
			}
		}
		if(petKeys != null) {
			for(java.lang.Long o : petKeys) {
				document.addField("petKeys_indexed_longs", o);
			}
			for(java.lang.Long o : petKeys) {
				document.addField("petKeys_stored_longs", o);
			}
		}
		super.indexBaseModel(document);

	}

	public static String varIndexedSiteEnrollment(String entityVar) {
		switch(entityVar) {
			case "enrollmentKey":
				return "enrollmentKey_indexed_long";
			case "userKeys":
				return "userKeys_indexed_longs";
			case "petKeys":
				return "petKeys_indexed_longs";
			default:
				return BaseModel.varIndexedBaseModel(entityVar);
		}
	}

	public static String varSearchSiteEnrollment(String entityVar) {
		switch(entityVar) {
			default:
				return BaseModel.varSearchBaseModel(entityVar);
		}
	}

	public static String varSuggestedSiteEnrollment(String entityVar) {
		switch(entityVar) {
			default:
				return BaseModel.varSuggestedBaseModel(entityVar);
		}
	}

	/////////////
	// store //
	/////////////

	@Override public void storeForClass(SolrDocument solrDocument) {
		storeSiteEnrollment(solrDocument);
	}
	public void storeSiteEnrollment(SolrDocument solrDocument) {
		SiteEnrollment oSiteEnrollment = (SiteEnrollment)this;

		oSiteEnrollment.setEnrollmentKey(Optional.ofNullable(solrDocument.get("enrollmentKey_stored_long")).map(v -> v.toString()).orElse(null));
		Optional.ofNullable((List<?>)solrDocument.get("userKeys_stored_longs")).orElse(Arrays.asList()).stream().filter(v -> v != null).forEach(v -> {
			oSiteEnrollment.addUserKeys(v.toString());
		});
		Optional.ofNullable((List<?>)solrDocument.get("petKeys_stored_longs")).orElse(Arrays.asList()).stream().filter(v -> v != null).forEach(v -> {
			oSiteEnrollment.addPetKeys(v.toString());
		});

		super.storeBaseModel(solrDocument);
	}

	//////////////////
	// apiRequest //
	//////////////////

	public void apiRequestSiteEnrollment() {
		ApiRequest apiRequest = Optional.ofNullable(siteRequest_).map(SiteRequestEnUS::getApiRequest_).orElse(null);
		Object o = Optional.ofNullable(apiRequest).map(ApiRequest::getOriginal).orElse(null);
		if(o != null && o instanceof SiteEnrollment) {
			SiteEnrollment original = (SiteEnrollment)o;
			if(!Objects.equals(enrollmentKey, original.getEnrollmentKey()))
				apiRequest.addVars("enrollmentKey");
			if(!Objects.equals(userKeys, original.getUserKeys()))
				apiRequest.addVars("userKeys");
			if(!Objects.equals(petKeys, original.getPetKeys()))
				apiRequest.addVars("petKeys");
			super.apiRequestBaseModel();
		}
	}

	//////////////
	// hashCode //
	//////////////

	@Override public int hashCode() {
		return Objects.hash(super.hashCode(), enrollmentKey, userKeys, petKeys);
	}

	////////////
	// equals //
	////////////

	@Override public boolean equals(Object o) {
		if(this == o)
			return true;
		if(!(o instanceof SiteEnrollment))
			return false;
		SiteEnrollment that = (SiteEnrollment)o;
		return super.equals(o)
				&& Objects.equals( enrollmentKey, that.enrollmentKey )
				&& Objects.equals( userKeys, that.userKeys )
				&& Objects.equals( petKeys, that.petKeys );
	}

	//////////////
	// toString //
	//////////////

	@Override public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString() + "\n");
		sb.append("SiteEnrollment { ");
		sb.append( "enrollmentKey: " ).append(enrollmentKey);
		sb.append( ", userKeys: " ).append(userKeys);
		sb.append( ", petKeys: " ).append(petKeys);
		sb.append(" }");
		return sb.toString();
	}

	public static final String VAR_enrollmentKey = "enrollmentKey";
	public static final String VAR_userKeys = "userKeys";
	public static final String VAR_petKeys = "petKeys";
	public static final String VAR_petSearch = "petSearch";
	public static final String VAR_pet_ = "pet_";
}
