package org.computate.nico.enus.pet;

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
import java.math.MathContext;
import java.util.Set;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.computate.nico.enus.search.SearchList;
import io.vertx.core.Future;
import java.util.Objects;
import java.util.List;
import org.apache.solr.client.solrj.SolrQuery;
import org.computate.nico.enus.enrollment.SiteEnrollment;
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
import java.lang.Boolean;
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
 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstClasse_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.nico.enus.pet.SitePet&fq=classeEtendGen_indexed_boolean:true">Find the class  in Solr. </a>
 * <br/>
 **/
public abstract class SitePetGen<DEV> extends BaseModel {
	protected static final Logger LOG = LoggerFactory.getLogger(SitePet.class);

	public static final List<String> ROLES = Arrays.asList("SiteAdmin");
	public static final List<String> ROLE_READS = Arrays.asList("");

	public static final String SitePet_AName = "a pet";
	public static final String SitePet_This = "this ";
	public static final String SitePet_ThisName = "this pet";
	public static final String SitePet_A = "a ";
	public static final String SitePet_TheName = "the pet";
	public static final String SitePet_NameSingular = "pet";
	public static final String SitePet_NamePlural = "pets";
	public static final String SitePet_NameActual = "current pet";
	public static final String SitePet_AllName = "all the pets";
	public static final String SitePet_SearchAllNameBy = "search pets by ";
	public static final String SitePet_Title = "pets";
	public static final String SitePet_ThePluralName = "the pets";
	public static final String SitePet_NoNameFound = "no pet found";
	public static final String SitePet_NameVar = "pet";
	public static final String SitePet_OfName = "of pet";
	public static final String SitePet_ANameAdjective = "a pet";
	public static final String SitePet_NameAdjectiveSingular = "pet";
	public static final String SitePet_NameAdjectivePlural = "pets";
	public static final String SitePet_Color = "pale-green";
	public static final String SitePet_IconGroup = "solid";
	public static final String SitePet_IconName = "dog";
	public static final Integer SitePet_Rows = 100;

	////////////
	// petKey //
	////////////

	/**	 The entity petKey
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected Long petKey;
	@JsonIgnore
	public Wrap<Long> petKeyWrap = new Wrap<Long>().var("petKey").o(petKey);

	/**	<br/> The entity petKey
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.nico.enus.pet.SitePet&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:petKey">Find the entity petKey in Solr</a>
	 * <br/>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _petKey(Wrap<Long> w);

	public Long getPetKey() {
		return petKey;
	}

	public void setPetKey(Long petKey) {
		this.petKey = petKey;
		this.petKeyWrap.alreadyInitialized = true;
	}
	@JsonIgnore
	public void setPetKey(String o) {
		this.petKey = SitePet.staticSetPetKey(siteRequest_, o);
		this.petKeyWrap.alreadyInitialized = true;
	}
	public static Long staticSetPetKey(SiteRequestEnUS siteRequest_, String o) {
		if(NumberUtils.isParsable(o))
			return Long.parseLong(o);
		return null;
	}
	protected SitePet petKeyInit() {
		if(!petKeyWrap.alreadyInitialized) {
			_petKey(petKeyWrap);
			if(petKey == null)
				setPetKey(petKeyWrap.o);
			petKeyWrap.o(null);
		}
		petKeyWrap.alreadyInitialized(true);
		return (SitePet)this;
	}

	public static Long staticSolrPetKey(SiteRequestEnUS siteRequest_, Long o) {
		return o;
	}

	public static String staticSolrStrPetKey(SiteRequestEnUS siteRequest_, Long o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqPetKey(SiteRequestEnUS siteRequest_, String o) {
		return SitePet.staticSolrStrPetKey(siteRequest_, SitePet.staticSolrPetKey(siteRequest_, SitePet.staticSetPetKey(siteRequest_, o)));
	}

	public Long solrPetKey() {
		return SitePet.staticSolrPetKey(siteRequest_, petKey);
	}

	public String strPetKey() {
		return petKey == null ? "" : petKey.toString();
	}

	public Long sqlPetKey() {
		return petKey;
	}

	public String jsonPetKey() {
		return petKey == null ? "" : petKey.toString();
	}

	public String htmTooltipPetKey() {
		return null;
	}

	public String htmPetKey() {
		return petKey == null ? "" : StringEscapeUtils.escapeHtml4(strPetKey());
	}

	//////////////////////
	// enrollmentSearch //
	//////////////////////

	/**	 The entity enrollmentSearch
	 *	 is defined as null before being initialized. 
	 */
	@JsonIgnore
	@JsonInclude(Include.NON_NULL)
	protected SearchList<SiteEnrollment> enrollmentSearch;
	@JsonIgnore
	public Wrap<SearchList<SiteEnrollment>> enrollmentSearchWrap = new Wrap<SearchList<SiteEnrollment>>().var("enrollmentSearch").o(enrollmentSearch);

	/**	<br/> The entity enrollmentSearch
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.nico.enus.pet.SitePet&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:enrollmentSearch">Find the entity enrollmentSearch in Solr</a>
	 * <br/>
	 * @param promise is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _enrollmentSearch(Promise<SearchList<SiteEnrollment>> promise);

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
	protected Future<SearchList<SiteEnrollment>> enrollmentSearchPromise() {
		Promise<SearchList<SiteEnrollment>> promise = Promise.promise();
		if(!enrollmentSearchWrap.alreadyInitialized) {
			Promise<SearchList<SiteEnrollment>> promise2 = Promise.promise();
			_enrollmentSearch(promise2);
			promise2.future().onSuccess(o -> {
				if(o != null && enrollmentSearch == null) {
					o.promiseDeepForClass(siteRequest_).onSuccess(a -> {
						setEnrollmentSearch(o);
						enrollmentSearchWrap.alreadyInitialized(true);
						promise.complete(o);
					}).onFailure(ex -> {
						promise.fail(ex);
					});
				} else {
					enrollmentSearchWrap.alreadyInitialized(true);
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
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.nico.enus.pet.SitePet&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:userKeys">Find the entity userKeys in Solr</a>
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
		Long l = SitePet.staticSetUserKeys(siteRequest_, o);
		if(l != null)
			addUserKeys(l);
		this.userKeysWrap.alreadyInitialized = true;
	}
	public static Long staticSetUserKeys(SiteRequestEnUS siteRequest_, String o) {
		if(NumberUtils.isParsable(o))
			return Long.parseLong(o);
		return null;
	}
	public SitePet addUserKeys(Long...objets) {
		for(Long o : objets) {
			addUserKeys(o);
		}
		return (SitePet)this;
	}
	public SitePet addUserKeys(Long o) {
		if(o != null && !userKeys.contains(o))
			this.userKeys.add(o);
		return (SitePet)this;
	}
	@JsonIgnore
	public void setUserKeys(JsonArray objets) {
		userKeys.clear();
		for(int i = 0; i < objets.size(); i++) {
			Long o = objets.getLong(i);
			addUserKeys(o);
		}
	}
	public SitePet addUserKeys(String o) {
		if(NumberUtils.isParsable(o)) {
			Long p = Long.parseLong(o);
			addUserKeys(p);
		}
		return (SitePet)this;
	}
	protected SitePet userKeysInit() {
		if(!userKeysWrap.alreadyInitialized) {
			_userKeys(userKeys);
		}
		userKeysWrap.alreadyInitialized(true);
		return (SitePet)this;
	}

	public static Long staticSolrUserKeys(SiteRequestEnUS siteRequest_, Long o) {
		return o;
	}

	public static String staticSolrStrUserKeys(SiteRequestEnUS siteRequest_, Long o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqUserKeys(SiteRequestEnUS siteRequest_, String o) {
		return SitePet.staticSolrStrUserKeys(siteRequest_, SitePet.staticSolrUserKeys(siteRequest_, SitePet.staticSetUserKeys(siteRequest_, o)));
	}

	public List<Long> solrUserKeys() {
		List<Long> l = new ArrayList<Long>();
		for(Long o : userKeys) {
			l.add(SitePet.staticSolrUserKeys(siteRequest_, o));
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

	////////////////////
	// enrollmentKeys //
	////////////////////

	/**	 The entity enrollmentKeys
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut List<Long>(). 
	 */
	@JsonProperty
	@JsonFormat(shape = JsonFormat.Shape.ARRAY)
	@JsonSerialize(contentUsing = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected List<Long> enrollmentKeys = new ArrayList<Long>();
	@JsonIgnore
	public Wrap<List<Long>> enrollmentKeysWrap = new Wrap<List<Long>>().var("enrollmentKeys").o(enrollmentKeys);

	/**	<br/> The entity enrollmentKeys
	 *  It is constructed before being initialized with the constructor by default List<Long>(). 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.nico.enus.pet.SitePet&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:enrollmentKeys">Find the entity enrollmentKeys in Solr</a>
	 * <br/>
	 * @param enrollmentKeys is the entity already constructed. 
	 **/
	protected abstract void _enrollmentKeys(List<Long> l);

	public List<Long> getEnrollmentKeys() {
		return enrollmentKeys;
	}

	public void setEnrollmentKeys(List<Long> enrollmentKeys) {
		this.enrollmentKeys = enrollmentKeys;
		this.enrollmentKeysWrap.alreadyInitialized = true;
	}
	@JsonIgnore
	public void setEnrollmentKeys(String o) {
		Long l = SitePet.staticSetEnrollmentKeys(siteRequest_, o);
		if(l != null)
			addEnrollmentKeys(l);
		this.enrollmentKeysWrap.alreadyInitialized = true;
	}
	public static Long staticSetEnrollmentKeys(SiteRequestEnUS siteRequest_, String o) {
		if(NumberUtils.isParsable(o))
			return Long.parseLong(o);
		return null;
	}
	public SitePet addEnrollmentKeys(Long...objets) {
		for(Long o : objets) {
			addEnrollmentKeys(o);
		}
		return (SitePet)this;
	}
	public SitePet addEnrollmentKeys(Long o) {
		if(o != null && !enrollmentKeys.contains(o))
			this.enrollmentKeys.add(o);
		return (SitePet)this;
	}
	@JsonIgnore
	public void setEnrollmentKeys(JsonArray objets) {
		enrollmentKeys.clear();
		for(int i = 0; i < objets.size(); i++) {
			Long o = objets.getLong(i);
			addEnrollmentKeys(o);
		}
	}
	public SitePet addEnrollmentKeys(String o) {
		if(NumberUtils.isParsable(o)) {
			Long p = Long.parseLong(o);
			addEnrollmentKeys(p);
		}
		return (SitePet)this;
	}
	protected SitePet enrollmentKeysInit() {
		if(!enrollmentKeysWrap.alreadyInitialized) {
			_enrollmentKeys(enrollmentKeys);
		}
		enrollmentKeysWrap.alreadyInitialized(true);
		return (SitePet)this;
	}

	public static Long staticSolrEnrollmentKeys(SiteRequestEnUS siteRequest_, Long o) {
		return o;
	}

	public static String staticSolrStrEnrollmentKeys(SiteRequestEnUS siteRequest_, Long o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqEnrollmentKeys(SiteRequestEnUS siteRequest_, String o) {
		return SitePet.staticSolrStrEnrollmentKeys(siteRequest_, SitePet.staticSolrEnrollmentKeys(siteRequest_, SitePet.staticSetEnrollmentKeys(siteRequest_, o)));
	}

	public List<Long> solrEnrollmentKeys() {
		List<Long> l = new ArrayList<Long>();
		for(Long o : enrollmentKeys) {
			l.add(SitePet.staticSolrEnrollmentKeys(siteRequest_, o));
		}
		return l;
	}

	public String strEnrollmentKeys() {
		return enrollmentKeys == null ? "" : enrollmentKeys.toString();
	}

	public List<Long> sqlEnrollmentKeys() {
		return enrollmentKeys;
	}

	public String jsonEnrollmentKeys() {
		return enrollmentKeys == null ? "" : enrollmentKeys.toString();
	}

	public String htmTooltipEnrollmentKeys() {
		return null;
	}

	public String htmEnrollmentKeys() {
		return enrollmentKeys == null ? "" : StringEscapeUtils.escapeHtml4(strEnrollmentKeys());
	}

	/////////////
	// petName //
	/////////////

	/**	 The entity petName
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String petName;
	@JsonIgnore
	public Wrap<String> petNameWrap = new Wrap<String>().var("petName").o(petName);

	/**	<br/> The entity petName
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.nico.enus.pet.SitePet&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:petName">Find the entity petName in Solr</a>
	 * <br/>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _petName(Wrap<String> w);

	public String getPetName() {
		return petName;
	}
	public void setPetName(String o) {
		this.petName = SitePet.staticSetPetName(siteRequest_, o);
		this.petNameWrap.alreadyInitialized = true;
	}
	public static String staticSetPetName(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	protected SitePet petNameInit() {
		if(!petNameWrap.alreadyInitialized) {
			_petName(petNameWrap);
			if(petName == null)
				setPetName(petNameWrap.o);
			petNameWrap.o(null);
		}
		petNameWrap.alreadyInitialized(true);
		return (SitePet)this;
	}

	public static String staticSolrPetName(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSolrStrPetName(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqPetName(SiteRequestEnUS siteRequest_, String o) {
		return SitePet.staticSolrStrPetName(siteRequest_, SitePet.staticSolrPetName(siteRequest_, SitePet.staticSetPetName(siteRequest_, o)));
	}

	public String solrPetName() {
		return SitePet.staticSolrPetName(siteRequest_, petName);
	}

	public String strPetName() {
		return petName == null ? "" : petName;
	}

	public String sqlPetName() {
		return petName;
	}

	public String jsonPetName() {
		return petName == null ? "" : petName;
	}

	public String htmTooltipPetName() {
		return null;
	}

	public String htmPetName() {
		return petName == null ? "" : StringEscapeUtils.escapeHtml4(strPetName());
	}

	///////////////////
	// petFoodAmount //
	///////////////////

	/**	 The entity petFoodAmount
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String petFoodAmount;
	@JsonIgnore
	public Wrap<String> petFoodAmountWrap = new Wrap<String>().var("petFoodAmount").o(petFoodAmount);

	/**	<br/> The entity petFoodAmount
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.nico.enus.pet.SitePet&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:petFoodAmount">Find the entity petFoodAmount in Solr</a>
	 * <br/>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _petFoodAmount(Wrap<String> w);

	public String getPetFoodAmount() {
		return petFoodAmount;
	}
	public void setPetFoodAmount(String o) {
		this.petFoodAmount = SitePet.staticSetPetFoodAmount(siteRequest_, o);
		this.petFoodAmountWrap.alreadyInitialized = true;
	}
	public static String staticSetPetFoodAmount(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	protected SitePet petFoodAmountInit() {
		if(!petFoodAmountWrap.alreadyInitialized) {
			_petFoodAmount(petFoodAmountWrap);
			if(petFoodAmount == null)
				setPetFoodAmount(petFoodAmountWrap.o);
			petFoodAmountWrap.o(null);
		}
		petFoodAmountWrap.alreadyInitialized(true);
		return (SitePet)this;
	}

	public static String staticSolrPetFoodAmount(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSolrStrPetFoodAmount(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqPetFoodAmount(SiteRequestEnUS siteRequest_, String o) {
		return SitePet.staticSolrStrPetFoodAmount(siteRequest_, SitePet.staticSolrPetFoodAmount(siteRequest_, SitePet.staticSetPetFoodAmount(siteRequest_, o)));
	}

	public String solrPetFoodAmount() {
		return SitePet.staticSolrPetFoodAmount(siteRequest_, petFoodAmount);
	}

	public String strPetFoodAmount() {
		return petFoodAmount == null ? "" : petFoodAmount;
	}

	public String sqlPetFoodAmount() {
		return petFoodAmount;
	}

	public String jsonPetFoodAmount() {
		return petFoodAmount == null ? "" : petFoodAmount;
	}

	public String htmTooltipPetFoodAmount() {
		return null;
	}

	public String htmPetFoodAmount() {
		return petFoodAmount == null ? "" : StringEscapeUtils.escapeHtml4(strPetFoodAmount());
	}

	/////////////
	// petFood //
	/////////////

	/**	 The entity petFood
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String petFood;
	@JsonIgnore
	public Wrap<String> petFoodWrap = new Wrap<String>().var("petFood").o(petFood);

	/**	<br/> The entity petFood
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.nico.enus.pet.SitePet&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:petFood">Find the entity petFood in Solr</a>
	 * <br/>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _petFood(Wrap<String> w);

	public String getPetFood() {
		return petFood;
	}
	public void setPetFood(String o) {
		this.petFood = SitePet.staticSetPetFood(siteRequest_, o);
		this.petFoodWrap.alreadyInitialized = true;
	}
	public static String staticSetPetFood(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	protected SitePet petFoodInit() {
		if(!petFoodWrap.alreadyInitialized) {
			_petFood(petFoodWrap);
			if(petFood == null)
				setPetFood(petFoodWrap.o);
			petFoodWrap.o(null);
		}
		petFoodWrap.alreadyInitialized(true);
		return (SitePet)this;
	}

	public static String staticSolrPetFood(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSolrStrPetFood(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqPetFood(SiteRequestEnUS siteRequest_, String o) {
		return SitePet.staticSolrStrPetFood(siteRequest_, SitePet.staticSolrPetFood(siteRequest_, SitePet.staticSetPetFood(siteRequest_, o)));
	}

	public String solrPetFood() {
		return SitePet.staticSolrPetFood(siteRequest_, petFood);
	}

	public String strPetFood() {
		return petFood == null ? "" : petFood;
	}

	public String sqlPetFood() {
		return petFood;
	}

	public String jsonPetFood() {
		return petFood == null ? "" : petFood;
	}

	public String htmTooltipPetFood() {
		return null;
	}

	public String htmPetFood() {
		return petFood == null ? "" : StringEscapeUtils.escapeHtml4(strPetFood());
	}

	/////////////
	// petSick //
	/////////////

	/**	 The entity petSick
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected Boolean petSick;
	@JsonIgnore
	public Wrap<Boolean> petSickWrap = new Wrap<Boolean>().var("petSick").o(petSick);

	/**	<br/> The entity petSick
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.nico.enus.pet.SitePet&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:petSick">Find the entity petSick in Solr</a>
	 * <br/>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _petSick(Wrap<Boolean> w);

	public Boolean getPetSick() {
		return petSick;
	}

	public void setPetSick(Boolean petSick) {
		this.petSick = petSick;
		this.petSickWrap.alreadyInitialized = true;
	}
	@JsonIgnore
	public void setPetSick(String o) {
		this.petSick = SitePet.staticSetPetSick(siteRequest_, o);
		this.petSickWrap.alreadyInitialized = true;
	}
	public static Boolean staticSetPetSick(SiteRequestEnUS siteRequest_, String o) {
		return Boolean.parseBoolean(o);
	}
	protected SitePet petSickInit() {
		if(!petSickWrap.alreadyInitialized) {
			_petSick(petSickWrap);
			if(petSick == null)
				setPetSick(petSickWrap.o);
			petSickWrap.o(null);
		}
		petSickWrap.alreadyInitialized(true);
		return (SitePet)this;
	}

	public static Boolean staticSolrPetSick(SiteRequestEnUS siteRequest_, Boolean o) {
		return o;
	}

	public static String staticSolrStrPetSick(SiteRequestEnUS siteRequest_, Boolean o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqPetSick(SiteRequestEnUS siteRequest_, String o) {
		return SitePet.staticSolrStrPetSick(siteRequest_, SitePet.staticSolrPetSick(siteRequest_, SitePet.staticSetPetSick(siteRequest_, o)));
	}

	public Boolean solrPetSick() {
		return SitePet.staticSolrPetSick(siteRequest_, petSick);
	}

	public String strPetSick() {
		return petSick == null ? "" : petSick.toString();
	}

	public Boolean sqlPetSick() {
		return petSick;
	}

	public String jsonPetSick() {
		return petSick == null ? "" : petSick.toString();
	}

	public String htmTooltipPetSick() {
		return null;
	}

	public String htmPetSick() {
		return petSick == null ? "" : StringEscapeUtils.escapeHtml4(strPetSick());
	}

	////////////////
	// petMedNote //
	////////////////

	/**	 The entity petMedNote
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String petMedNote;
	@JsonIgnore
	public Wrap<String> petMedNoteWrap = new Wrap<String>().var("petMedNote").o(petMedNote);

	/**	<br/> The entity petMedNote
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.nico.enus.pet.SitePet&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:petMedNote">Find the entity petMedNote in Solr</a>
	 * <br/>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _petMedNote(Wrap<String> w);

	public String getPetMedNote() {
		return petMedNote;
	}
	public void setPetMedNote(String o) {
		this.petMedNote = SitePet.staticSetPetMedNote(siteRequest_, o);
		this.petMedNoteWrap.alreadyInitialized = true;
	}
	public static String staticSetPetMedNote(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	protected SitePet petMedNoteInit() {
		if(!petMedNoteWrap.alreadyInitialized) {
			_petMedNote(petMedNoteWrap);
			if(petMedNote == null)
				setPetMedNote(petMedNoteWrap.o);
			petMedNoteWrap.o(null);
		}
		petMedNoteWrap.alreadyInitialized(true);
		return (SitePet)this;
	}

	public static String staticSolrPetMedNote(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSolrStrPetMedNote(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqPetMedNote(SiteRequestEnUS siteRequest_, String o) {
		return SitePet.staticSolrStrPetMedNote(siteRequest_, SitePet.staticSolrPetMedNote(siteRequest_, SitePet.staticSetPetMedNote(siteRequest_, o)));
	}

	public String solrPetMedNote() {
		return SitePet.staticSolrPetMedNote(siteRequest_, petMedNote);
	}

	public String strPetMedNote() {
		return petMedNote == null ? "" : petMedNote;
	}

	public String sqlPetMedNote() {
		return petMedNote;
	}

	public String jsonPetMedNote() {
		return petMedNote == null ? "" : petMedNote;
	}

	public String htmTooltipPetMedNote() {
		return null;
	}

	public String htmPetMedNote() {
		return petMedNote == null ? "" : StringEscapeUtils.escapeHtml4(strPetMedNote());
	}

	////////////////
	// petTrouble //
	////////////////

	/**	 The entity petTrouble
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String petTrouble;
	@JsonIgnore
	public Wrap<String> petTroubleWrap = new Wrap<String>().var("petTrouble").o(petTrouble);

	/**	<br/> The entity petTrouble
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.nico.enus.pet.SitePet&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:petTrouble">Find the entity petTrouble in Solr</a>
	 * <br/>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _petTrouble(Wrap<String> w);

	public String getPetTrouble() {
		return petTrouble;
	}
	public void setPetTrouble(String o) {
		this.petTrouble = SitePet.staticSetPetTrouble(siteRequest_, o);
		this.petTroubleWrap.alreadyInitialized = true;
	}
	public static String staticSetPetTrouble(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	protected SitePet petTroubleInit() {
		if(!petTroubleWrap.alreadyInitialized) {
			_petTrouble(petTroubleWrap);
			if(petTrouble == null)
				setPetTrouble(petTroubleWrap.o);
			petTroubleWrap.o(null);
		}
		petTroubleWrap.alreadyInitialized(true);
		return (SitePet)this;
	}

	public static String staticSolrPetTrouble(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSolrStrPetTrouble(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqPetTrouble(SiteRequestEnUS siteRequest_, String o) {
		return SitePet.staticSolrStrPetTrouble(siteRequest_, SitePet.staticSolrPetTrouble(siteRequest_, SitePet.staticSetPetTrouble(siteRequest_, o)));
	}

	public String solrPetTrouble() {
		return SitePet.staticSolrPetTrouble(siteRequest_, petTrouble);
	}

	public String strPetTrouble() {
		return petTrouble == null ? "" : petTrouble;
	}

	public String sqlPetTrouble() {
		return petTrouble;
	}

	public String jsonPetTrouble() {
		return petTrouble == null ? "" : petTrouble;
	}

	public String htmTooltipPetTrouble() {
		return null;
	}

	public String htmPetTrouble() {
		return petTrouble == null ? "" : StringEscapeUtils.escapeHtml4(strPetTrouble());
	}

	////////////
	// update //
	////////////

	/**	 The entity update
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected Boolean update;
	@JsonIgnore
	public Wrap<Boolean> updateWrap = new Wrap<Boolean>().var("update").o(update);

	/**	<br/> The entity update
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.nico.enus.pet.SitePet&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:update">Find the entity update in Solr</a>
	 * <br/>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _update(Wrap<Boolean> w);

	public Boolean getUpdate() {
		return update;
	}

	public void setUpdate(Boolean update) {
		this.update = update;
		this.updateWrap.alreadyInitialized = true;
	}
	@JsonIgnore
	public void setUpdate(String o) {
		this.update = SitePet.staticSetUpdate(siteRequest_, o);
		this.updateWrap.alreadyInitialized = true;
	}
	public static Boolean staticSetUpdate(SiteRequestEnUS siteRequest_, String o) {
		return Boolean.parseBoolean(o);
	}
	protected SitePet updateInit() {
		if(!updateWrap.alreadyInitialized) {
			_update(updateWrap);
			if(update == null)
				setUpdate(updateWrap.o);
			updateWrap.o(null);
		}
		updateWrap.alreadyInitialized(true);
		return (SitePet)this;
	}

	public static Boolean staticSolrUpdate(SiteRequestEnUS siteRequest_, Boolean o) {
		return o;
	}

	public static String staticSolrStrUpdate(SiteRequestEnUS siteRequest_, Boolean o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqUpdate(SiteRequestEnUS siteRequest_, String o) {
		return SitePet.staticSolrStrUpdate(siteRequest_, SitePet.staticSolrUpdate(siteRequest_, SitePet.staticSetUpdate(siteRequest_, o)));
	}

	public Boolean solrUpdate() {
		return SitePet.staticSolrUpdate(siteRequest_, update);
	}

	public String strUpdate() {
		return update == null ? "" : update.toString();
	}

	public Boolean sqlUpdate() {
		return update;
	}

	public String jsonUpdate() {
		return update == null ? "" : update.toString();
	}

	public String htmTooltipUpdate() {
		return null;
	}

	public String htmUpdate() {
		return update == null ? "" : StringEscapeUtils.escapeHtml4(strUpdate());
	}

	///////////////
	// petAmount //
	///////////////

	/**	 The entity petAmount
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String petAmount;
	@JsonIgnore
	public Wrap<String> petAmountWrap = new Wrap<String>().var("petAmount").o(petAmount);

	/**	<br/> The entity petAmount
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.nico.enus.pet.SitePet&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:petAmount">Find the entity petAmount in Solr</a>
	 * <br/>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _petAmount(Wrap<String> w);

	public String getPetAmount() {
		return petAmount;
	}
	public void setPetAmount(String o) {
		this.petAmount = SitePet.staticSetPetAmount(siteRequest_, o);
		this.petAmountWrap.alreadyInitialized = true;
	}
	public static String staticSetPetAmount(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	protected SitePet petAmountInit() {
		if(!petAmountWrap.alreadyInitialized) {
			_petAmount(petAmountWrap);
			if(petAmount == null)
				setPetAmount(petAmountWrap.o);
			petAmountWrap.o(null);
		}
		petAmountWrap.alreadyInitialized(true);
		return (SitePet)this;
	}

	public static String staticSolrPetAmount(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSolrStrPetAmount(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqPetAmount(SiteRequestEnUS siteRequest_, String o) {
		return SitePet.staticSolrStrPetAmount(siteRequest_, SitePet.staticSolrPetAmount(siteRequest_, SitePet.staticSetPetAmount(siteRequest_, o)));
	}

	public String solrPetAmount() {
		return SitePet.staticSolrPetAmount(siteRequest_, petAmount);
	}

	public String strPetAmount() {
		return petAmount == null ? "" : petAmount;
	}

	public String sqlPetAmount() {
		return petAmount;
	}

	public String jsonPetAmount() {
		return petAmount == null ? "" : petAmount;
	}

	public String htmTooltipPetAmount() {
		return null;
	}

	public String htmPetAmount() {
		return petAmount == null ? "" : StringEscapeUtils.escapeHtml4(strPetAmount());
	}

	//////////////
	// initDeep //
	//////////////

	protected boolean alreadyInitializedSitePet = false;

	public Future<Void> promiseDeepSitePet(SiteRequestEnUS siteRequest_) {
		setSiteRequest_(siteRequest_);
		if(!alreadyInitializedSitePet) {
			alreadyInitializedSitePet = true;
			return promiseDeepSitePet();
		} else {
			return Future.succeededFuture();
		}
	}

	public Future<Void> promiseDeepSitePet() {
		Promise<Void> promise = Promise.promise();
		Promise<Void> promise2 = Promise.promise();
		promiseSitePet(promise2);
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

	public Future<Void> promiseSitePet(Promise<Void> promise) {
		Future.future(a -> a.complete()).compose(a -> {
			Promise<Void> promise2 = Promise.promise();
			try {
				petKeyInit();
				promise2.complete();
			} catch(Exception ex) {
				promise2.fail(ex);
			}
			return promise2.future();
		}).compose(a -> {
			Promise<Void> promise2 = Promise.promise();
			enrollmentSearchPromise().onSuccess(enrollmentSearch -> {
				promise2.complete();
			}).onFailure(ex -> {
				promise2.fail(ex);
			});
			return promise2.future();
		}).compose(a -> {
			Promise<Void> promise2 = Promise.promise();
			try {
				userKeysInit();
				enrollmentKeysInit();
				petNameInit();
				petFoodAmountInit();
				petFoodInit();
				petSickInit();
				petMedNoteInit();
				petTroubleInit();
				updateInit();
				petAmountInit();
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
		return promiseDeepSitePet(siteRequest_);
	}

	/////////////////
	// siteRequest //
	/////////////////

	public void siteRequestSitePet(SiteRequestEnUS siteRequest_) {
			super.siteRequestBaseModel(siteRequest_);
		if(enrollmentSearch != null)
			enrollmentSearch.setSiteRequest_(siteRequest_);
	}

	public void siteRequestForClass(SiteRequestEnUS siteRequest_) {
		siteRequestSitePet(siteRequest_);
	}

	/////////////
	// obtain //
	/////////////

	@Override public Object obtainForClass(String var) {
		String[] vars = StringUtils.split(var, ".");
		Object o = null;
		for(String v : vars) {
			if(o == null)
				o = obtainSitePet(v);
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
	public Object obtainSitePet(String var) {
		SitePet oSitePet = (SitePet)this;
		switch(var) {
			case "petKey":
				return oSitePet.petKey;
			case "enrollmentSearch":
				return oSitePet.enrollmentSearch;
			case "userKeys":
				return oSitePet.userKeys;
			case "enrollmentKeys":
				return oSitePet.enrollmentKeys;
			case "petName":
				return oSitePet.petName;
			case "petFoodAmount":
				return oSitePet.petFoodAmount;
			case "petFood":
				return oSitePet.petFood;
			case "petSick":
				return oSitePet.petSick;
			case "petMedNote":
				return oSitePet.petMedNote;
			case "petTrouble":
				return oSitePet.petTrouble;
			case "update":
				return oSitePet.update;
			case "petAmount":
				return oSitePet.petAmount;
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
				o = attributeSitePet(v, val);
			else if(o instanceof BaseModel) {
				BaseModel baseModel = (BaseModel)o;
				o = baseModel.attributeForClass(v, val);
			}
		}
		return o != null;
	}
	public Object attributeSitePet(String var, Object val) {
		SitePet oSitePet = (SitePet)this;
		switch(var) {
			case "enrollmentKeys":
				oSitePet.addEnrollmentKeys((Long)val);
				if(!saves.contains("enrollmentKeys"))
					saves.add("enrollmentKeys");
				return val;
			default:
				return super.attributeBaseModel(var, val);
		}
	}

	///////////////
	// staticSet //
	///////////////

	public static Object staticSetForClass(String entityVar, SiteRequestEnUS siteRequest_, String o) {
		return staticSetSitePet(entityVar,  siteRequest_, o);
	}
	public static Object staticSetSitePet(String entityVar, SiteRequestEnUS siteRequest_, String o) {
		switch(entityVar) {
		case "petKey":
			return SitePet.staticSetPetKey(siteRequest_, o);
		case "userKeys":
			return SitePet.staticSetUserKeys(siteRequest_, o);
		case "enrollmentKeys":
			return SitePet.staticSetEnrollmentKeys(siteRequest_, o);
		case "petName":
			return SitePet.staticSetPetName(siteRequest_, o);
		case "petFoodAmount":
			return SitePet.staticSetPetFoodAmount(siteRequest_, o);
		case "petFood":
			return SitePet.staticSetPetFood(siteRequest_, o);
		case "petSick":
			return SitePet.staticSetPetSick(siteRequest_, o);
		case "petMedNote":
			return SitePet.staticSetPetMedNote(siteRequest_, o);
		case "petTrouble":
			return SitePet.staticSetPetTrouble(siteRequest_, o);
		case "update":
			return SitePet.staticSetUpdate(siteRequest_, o);
		case "petAmount":
			return SitePet.staticSetPetAmount(siteRequest_, o);
			default:
				return BaseModel.staticSetBaseModel(entityVar,  siteRequest_, o);
		}
	}

	////////////////
	// staticSolr //
	////////////////

	public static Object staticSolrForClass(String entityVar, SiteRequestEnUS siteRequest_, Object o) {
		return staticSolrSitePet(entityVar,  siteRequest_, o);
	}
	public static Object staticSolrSitePet(String entityVar, SiteRequestEnUS siteRequest_, Object o) {
		switch(entityVar) {
		case "petKey":
			return SitePet.staticSolrPetKey(siteRequest_, (Long)o);
		case "userKeys":
			return SitePet.staticSolrUserKeys(siteRequest_, (Long)o);
		case "enrollmentKeys":
			return SitePet.staticSolrEnrollmentKeys(siteRequest_, (Long)o);
		case "petName":
			return SitePet.staticSolrPetName(siteRequest_, (String)o);
		case "petFoodAmount":
			return SitePet.staticSolrPetFoodAmount(siteRequest_, (String)o);
		case "petFood":
			return SitePet.staticSolrPetFood(siteRequest_, (String)o);
		case "petSick":
			return SitePet.staticSolrPetSick(siteRequest_, (Boolean)o);
		case "petMedNote":
			return SitePet.staticSolrPetMedNote(siteRequest_, (String)o);
		case "petTrouble":
			return SitePet.staticSolrPetTrouble(siteRequest_, (String)o);
		case "update":
			return SitePet.staticSolrUpdate(siteRequest_, (Boolean)o);
		case "petAmount":
			return SitePet.staticSolrPetAmount(siteRequest_, (String)o);
			default:
				return BaseModel.staticSolrBaseModel(entityVar,  siteRequest_, o);
		}
	}

	///////////////////
	// staticSolrStr //
	///////////////////

	public static String staticSolrStrForClass(String entityVar, SiteRequestEnUS siteRequest_, Object o) {
		return staticSolrStrSitePet(entityVar,  siteRequest_, o);
	}
	public static String staticSolrStrSitePet(String entityVar, SiteRequestEnUS siteRequest_, Object o) {
		switch(entityVar) {
		case "petKey":
			return SitePet.staticSolrStrPetKey(siteRequest_, (Long)o);
		case "userKeys":
			return SitePet.staticSolrStrUserKeys(siteRequest_, (Long)o);
		case "enrollmentKeys":
			return SitePet.staticSolrStrEnrollmentKeys(siteRequest_, (Long)o);
		case "petName":
			return SitePet.staticSolrStrPetName(siteRequest_, (String)o);
		case "petFoodAmount":
			return SitePet.staticSolrStrPetFoodAmount(siteRequest_, (String)o);
		case "petFood":
			return SitePet.staticSolrStrPetFood(siteRequest_, (String)o);
		case "petSick":
			return SitePet.staticSolrStrPetSick(siteRequest_, (Boolean)o);
		case "petMedNote":
			return SitePet.staticSolrStrPetMedNote(siteRequest_, (String)o);
		case "petTrouble":
			return SitePet.staticSolrStrPetTrouble(siteRequest_, (String)o);
		case "update":
			return SitePet.staticSolrStrUpdate(siteRequest_, (Boolean)o);
		case "petAmount":
			return SitePet.staticSolrStrPetAmount(siteRequest_, (String)o);
			default:
				return BaseModel.staticSolrStrBaseModel(entityVar,  siteRequest_, o);
		}
	}

	//////////////////
	// staticSolrFq //
	//////////////////

	public static String staticSolrFqForClass(String entityVar, SiteRequestEnUS siteRequest_, String o) {
		return staticSolrFqSitePet(entityVar,  siteRequest_, o);
	}
	public static String staticSolrFqSitePet(String entityVar, SiteRequestEnUS siteRequest_, String o) {
		switch(entityVar) {
		case "petKey":
			return SitePet.staticSolrFqPetKey(siteRequest_, o);
		case "userKeys":
			return SitePet.staticSolrFqUserKeys(siteRequest_, o);
		case "enrollmentKeys":
			return SitePet.staticSolrFqEnrollmentKeys(siteRequest_, o);
		case "petName":
			return SitePet.staticSolrFqPetName(siteRequest_, o);
		case "petFoodAmount":
			return SitePet.staticSolrFqPetFoodAmount(siteRequest_, o);
		case "petFood":
			return SitePet.staticSolrFqPetFood(siteRequest_, o);
		case "petSick":
			return SitePet.staticSolrFqPetSick(siteRequest_, o);
		case "petMedNote":
			return SitePet.staticSolrFqPetMedNote(siteRequest_, o);
		case "petTrouble":
			return SitePet.staticSolrFqPetTrouble(siteRequest_, o);
		case "update":
			return SitePet.staticSolrFqUpdate(siteRequest_, o);
		case "petAmount":
			return SitePet.staticSolrFqPetAmount(siteRequest_, o);
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
					o = defineSitePet(v, val);
				else if(o instanceof BaseModel) {
					BaseModel oBaseModel = (BaseModel)o;
					o = oBaseModel.defineForClass(v, val);
				}
			}
		}
		return o != null;
	}
	public Object defineSitePet(String var, String val) {
		switch(var.toLowerCase()) {
			case "petname":
				if(val != null)
					setPetName(val);
				saves.add("petName");
				return val;
			case "petfoodamount":
				if(val != null)
					setPetFoodAmount(val);
				saves.add("petFoodAmount");
				return val;
			case "petfood":
				if(val != null)
					setPetFood(val);
				saves.add("petFood");
				return val;
			case "petsick":
				if(val != null)
					setPetSick(val);
				saves.add("petSick");
				return val;
			case "petmednote":
				if(val != null)
					setPetMedNote(val);
				saves.add("petMedNote");
				return val;
			case "pettrouble":
				if(val != null)
					setPetTrouble(val);
				saves.add("petTrouble");
				return val;
			case "update":
				if(val != null)
					setUpdate(val);
				saves.add("update");
				return val;
			case "petamount":
				if(val != null)
					setPetAmount(val);
				saves.add("petAmount");
				return val;
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
					o = defineSitePet(v, val);
				else if(o instanceof BaseModel) {
					BaseModel oBaseModel = (BaseModel)o;
					o = oBaseModel.defineForClass(v, val);
				}
			}
		}
		return o != null;
	}
	public Object defineSitePet(String var, Object val) {
		switch(var.toLowerCase()) {
			case "petname":
				if(val instanceof String)
					setPetName((String)val);
				saves.add("petName");
				return val;
			case "petfoodamount":
				if(val instanceof String)
					setPetFoodAmount((String)val);
				saves.add("petFoodAmount");
				return val;
			case "petfood":
				if(val instanceof String)
					setPetFood((String)val);
				saves.add("petFood");
				return val;
			case "petsick":
				if(val instanceof Boolean)
					setPetSick((Boolean)val);
				saves.add("petSick");
				return val;
			case "petmednote":
				if(val instanceof String)
					setPetMedNote((String)val);
				saves.add("petMedNote");
				return val;
			case "pettrouble":
				if(val instanceof String)
					setPetTrouble((String)val);
				saves.add("petTrouble");
				return val;
			case "update":
				if(val instanceof Boolean)
					setUpdate((Boolean)val);
				saves.add("update");
				return val;
			case "petamount":
				if(val instanceof String)
					setPetAmount((String)val);
				saves.add("petAmount");
				return val;
			default:
				return super.defineBaseModel(var, val);
		}
	}

	/////////////
	// populate //
	/////////////

	@Override public void populateForClass(SolrDocument solrDocument) {
		populateSitePet(solrDocument);
	}
	public void populateSitePet(SolrDocument solrDocument) {
		SitePet oSitePet = (SitePet)this;
		saves = (List<String>)solrDocument.get("saves_stored_strings");
		if(saves != null) {

			if(saves.contains("petKey")) {
				Long petKey = (Long)solrDocument.get("petKey_stored_long");
				if(petKey != null)
					oSitePet.setPetKey(petKey);
			}

			if(saves.contains("userKeys")) {
				List<Long> userKeys = (List<Long>)solrDocument.get("userKeys_stored_longs");
				if(userKeys != null)
					oSitePet.userKeys.addAll(userKeys);
			}

			List<Long> enrollmentKeys = (List<Long>)solrDocument.get("enrollmentKeys_stored_longs");
			if(enrollmentKeys != null)
				oSitePet.enrollmentKeys.addAll(enrollmentKeys);

			if(saves.contains("petName")) {
				String petName = (String)solrDocument.get("petName_stored_string");
				if(petName != null)
					oSitePet.setPetName(petName);
			}

			if(saves.contains("petFoodAmount")) {
				String petFoodAmount = (String)solrDocument.get("petFoodAmount_stored_string");
				if(petFoodAmount != null)
					oSitePet.setPetFoodAmount(petFoodAmount);
			}

			if(saves.contains("petFood")) {
				String petFood = (String)solrDocument.get("petFood_stored_string");
				if(petFood != null)
					oSitePet.setPetFood(petFood);
			}

			if(saves.contains("petSick")) {
				Boolean petSick = (Boolean)solrDocument.get("petSick_stored_boolean");
				if(petSick != null)
					oSitePet.setPetSick(petSick);
			}

			if(saves.contains("petMedNote")) {
				String petMedNote = (String)solrDocument.get("petMedNote_stored_string");
				if(petMedNote != null)
					oSitePet.setPetMedNote(petMedNote);
			}

			if(saves.contains("petTrouble")) {
				String petTrouble = (String)solrDocument.get("petTrouble_stored_string");
				if(petTrouble != null)
					oSitePet.setPetTrouble(petTrouble);
			}

			if(saves.contains("update")) {
				Boolean update = (Boolean)solrDocument.get("update_stored_boolean");
				if(update != null)
					oSitePet.setUpdate(update);
			}

			if(saves.contains("petAmount")) {
				String petAmount = (String)solrDocument.get("petAmount_stored_string");
				if(petAmount != null)
					oSitePet.setPetAmount(petAmount);
			}
		}

		super.populateBaseModel(solrDocument);
	}

	public void indexSitePet(SolrInputDocument document) {
		if(petKey != null) {
			document.addField("petKey_indexed_long", petKey);
			document.addField("petKey_stored_long", petKey);
		}
		if(userKeys != null) {
			for(java.lang.Long o : userKeys) {
				document.addField("userKeys_indexed_longs", o);
			}
			for(java.lang.Long o : userKeys) {
				document.addField("userKeys_stored_longs", o);
			}
		}
		if(enrollmentKeys != null) {
			for(java.lang.Long o : enrollmentKeys) {
				document.addField("enrollmentKeys_indexed_longs", o);
			}
			for(java.lang.Long o : enrollmentKeys) {
				document.addField("enrollmentKeys_stored_longs", o);
			}
		}
		if(petName != null) {
			document.addField("petName_indexed_string", petName);
			document.addField("petName_stored_string", petName);
		}
		if(petFoodAmount != null) {
			document.addField("petFoodAmount_indexed_string", petFoodAmount);
			document.addField("petFoodAmount_stored_string", petFoodAmount);
		}
		if(petFood != null) {
			document.addField("petFood_indexed_string", petFood);
			document.addField("petFood_stored_string", petFood);
		}
		if(petSick != null) {
			document.addField("petSick_indexed_boolean", petSick);
			document.addField("petSick_stored_boolean", petSick);
		}
		if(petMedNote != null) {
			document.addField("petMedNote_indexed_string", petMedNote);
			document.addField("petMedNote_stored_string", petMedNote);
		}
		if(petTrouble != null) {
			document.addField("petTrouble_indexed_string", petTrouble);
			document.addField("petTrouble_stored_string", petTrouble);
		}
		if(update != null) {
			document.addField("update_indexed_boolean", update);
			document.addField("update_stored_boolean", update);
		}
		if(petAmount != null) {
			document.addField("petAmount_indexed_string", petAmount);
			document.addField("petAmount_stored_string", petAmount);
		}
		super.indexBaseModel(document);

	}

	public static String varIndexedSitePet(String entityVar) {
		switch(entityVar) {
			case "petKey":
				return "petKey_indexed_long";
			case "userKeys":
				return "userKeys_indexed_longs";
			case "enrollmentKeys":
				return "enrollmentKeys_indexed_longs";
			case "petName":
				return "petName_indexed_string";
			case "petFoodAmount":
				return "petFoodAmount_indexed_string";
			case "petFood":
				return "petFood_indexed_string";
			case "petSick":
				return "petSick_indexed_boolean";
			case "petMedNote":
				return "petMedNote_indexed_string";
			case "petTrouble":
				return "petTrouble_indexed_string";
			case "update":
				return "update_indexed_boolean";
			case "petAmount":
				return "petAmount_indexed_string";
			default:
				return BaseModel.varIndexedBaseModel(entityVar);
		}
	}

	public static String varSearchSitePet(String entityVar) {
		switch(entityVar) {
			default:
				return BaseModel.varSearchBaseModel(entityVar);
		}
	}

	public static String varSuggestedSitePet(String entityVar) {
		switch(entityVar) {
			default:
				return BaseModel.varSuggestedBaseModel(entityVar);
		}
	}

	/////////////
	// store //
	/////////////

	@Override public void storeForClass(SolrDocument solrDocument) {
		storeSitePet(solrDocument);
	}
	public void storeSitePet(SolrDocument solrDocument) {
		SitePet oSitePet = (SitePet)this;

		oSitePet.setPetKey(Optional.ofNullable(solrDocument.get("petKey_stored_long")).map(v -> v.toString()).orElse(null));
		Optional.ofNullable((List<?>)solrDocument.get("userKeys_stored_longs")).orElse(Arrays.asList()).stream().filter(v -> v != null).forEach(v -> {
			oSitePet.addUserKeys(v.toString());
		});
		Optional.ofNullable((List<?>)solrDocument.get("enrollmentKeys_stored_longs")).orElse(Arrays.asList()).stream().filter(v -> v != null).forEach(v -> {
			oSitePet.addEnrollmentKeys(v.toString());
		});
		oSitePet.setPetName(Optional.ofNullable(solrDocument.get("petName_stored_string")).map(v -> v.toString()).orElse(null));
		oSitePet.setPetFoodAmount(Optional.ofNullable(solrDocument.get("petFoodAmount_stored_string")).map(v -> v.toString()).orElse(null));
		oSitePet.setPetFood(Optional.ofNullable(solrDocument.get("petFood_stored_string")).map(v -> v.toString()).orElse(null));
		oSitePet.setPetSick(Optional.ofNullable(solrDocument.get("petSick_stored_boolean")).map(v -> v.toString()).orElse(null));
		oSitePet.setPetMedNote(Optional.ofNullable(solrDocument.get("petMedNote_stored_string")).map(v -> v.toString()).orElse(null));
		oSitePet.setPetTrouble(Optional.ofNullable(solrDocument.get("petTrouble_stored_string")).map(v -> v.toString()).orElse(null));
		oSitePet.setUpdate(Optional.ofNullable(solrDocument.get("update_stored_boolean")).map(v -> v.toString()).orElse(null));
		oSitePet.setPetAmount(Optional.ofNullable(solrDocument.get("petAmount_stored_string")).map(v -> v.toString()).orElse(null));

		super.storeBaseModel(solrDocument);
	}

	//////////////////
	// apiRequest //
	//////////////////

	public void apiRequestSitePet() {
		ApiRequest apiRequest = Optional.ofNullable(siteRequest_).map(SiteRequestEnUS::getApiRequest_).orElse(null);
		Object o = Optional.ofNullable(apiRequest).map(ApiRequest::getOriginal).orElse(null);
		if(o != null && o instanceof SitePet) {
			SitePet original = (SitePet)o;
			if(!Objects.equals(petKey, original.getPetKey()))
				apiRequest.addVars("petKey");
			if(!Objects.equals(userKeys, original.getUserKeys()))
				apiRequest.addVars("userKeys");
			if(!Objects.equals(enrollmentKeys, original.getEnrollmentKeys()))
				apiRequest.addVars("enrollmentKeys");
			if(!Objects.equals(petName, original.getPetName()))
				apiRequest.addVars("petName");
			if(!Objects.equals(petFoodAmount, original.getPetFoodAmount()))
				apiRequest.addVars("petFoodAmount");
			if(!Objects.equals(petFood, original.getPetFood()))
				apiRequest.addVars("petFood");
			if(!Objects.equals(petSick, original.getPetSick()))
				apiRequest.addVars("petSick");
			if(!Objects.equals(petMedNote, original.getPetMedNote()))
				apiRequest.addVars("petMedNote");
			if(!Objects.equals(petTrouble, original.getPetTrouble()))
				apiRequest.addVars("petTrouble");
			if(!Objects.equals(update, original.getUpdate()))
				apiRequest.addVars("update");
			if(!Objects.equals(petAmount, original.getPetAmount()))
				apiRequest.addVars("petAmount");
			super.apiRequestBaseModel();
		}
	}

	//////////////
	// hashCode //
	//////////////

	@Override public int hashCode() {
		return Objects.hash(super.hashCode(), petKey, userKeys, enrollmentKeys, petName, petFoodAmount, petFood, petSick, petMedNote, petTrouble, update, petAmount);
	}

	////////////
	// equals //
	////////////

	@Override public boolean equals(Object o) {
		if(this == o)
			return true;
		if(!(o instanceof SitePet))
			return false;
		SitePet that = (SitePet)o;
		return super.equals(o)
				&& Objects.equals( petKey, that.petKey )
				&& Objects.equals( userKeys, that.userKeys )
				&& Objects.equals( enrollmentKeys, that.enrollmentKeys )
				&& Objects.equals( petName, that.petName )
				&& Objects.equals( petFoodAmount, that.petFoodAmount )
				&& Objects.equals( petFood, that.petFood )
				&& Objects.equals( petSick, that.petSick )
				&& Objects.equals( petMedNote, that.petMedNote )
				&& Objects.equals( petTrouble, that.petTrouble )
				&& Objects.equals( update, that.update )
				&& Objects.equals( petAmount, that.petAmount );
	}

	//////////////
	// toString //
	//////////////

	@Override public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString() + "\n");
		sb.append("SitePet { ");
		sb.append( "petKey: " ).append(petKey);
		sb.append( ", userKeys: " ).append(userKeys);
		sb.append( ", enrollmentKeys: " ).append(enrollmentKeys);
		sb.append( ", petName: \"" ).append(petName).append( "\"" );
		sb.append( ", petFoodAmount: \"" ).append(petFoodAmount).append( "\"" );
		sb.append( ", petFood: \"" ).append(petFood).append( "\"" );
		sb.append( ", petSick: " ).append(petSick);
		sb.append( ", petMedNote: \"" ).append(petMedNote).append( "\"" );
		sb.append( ", petTrouble: \"" ).append(petTrouble).append( "\"" );
		sb.append( ", update: " ).append(update);
		sb.append( ", petAmount: \"" ).append(petAmount).append( "\"" );
		sb.append(" }");
		return sb.toString();
	}

	public static final String VAR_petKey = "petKey";
	public static final String VAR_enrollmentSearch = "enrollmentSearch";
	public static final String VAR_userKeys = "userKeys";
	public static final String VAR_enrollmentKeys = "enrollmentKeys";
	public static final String VAR_petName = "petName";
	public static final String VAR_petFoodAmount = "petFoodAmount";
	public static final String VAR_petFood = "petFood";
	public static final String VAR_petSick = "petSick";
	public static final String VAR_petMedNote = "petMedNote";
	public static final String VAR_petTrouble = "petTrouble";
	public static final String VAR_update = "update";
	public static final String VAR_petAmount = "petAmount";
}
