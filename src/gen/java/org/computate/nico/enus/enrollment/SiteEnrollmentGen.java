package org.computate.nico.enus.enrollment;

import java.util.Arrays;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import java.util.Date;
import java.util.HashMap;
import org.computate.nico.enus.context.SiteContextEnUS;
import org.apache.commons.lang3.StringUtils;
import org.computate.nico.enus.writer.AllWriter;
import java.text.NumberFormat;
import io.vertx.core.logging.LoggerFactory;
import java.util.ArrayList;
import org.computate.nico.enus.request.SiteRequestEnUS;
import org.apache.commons.collections.CollectionUtils;
import java.lang.Long;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.computate.nico.enus.user.SiteUser;
import io.vertx.core.json.JsonObject;
import java.lang.String;
import io.vertx.core.logging.Logger;
import org.computate.nico.enus.wrap.Wrap;
import java.math.RoundingMode;
import org.computate.nico.enus.cluster.Cluster;
import org.computate.nico.enus.pet.SitePet;
import java.math.MathContext;
import org.apache.solr.client.solrj.response.QueryResponse;
import java.util.Set;
import org.apache.commons.text.StringEscapeUtils;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.computate.nico.enus.request.api.ApiRequest;
import org.computate.nico.enus.search.SearchList;
import org.apache.solr.client.solrj.SolrClient;
import java.util.Objects;
import io.vertx.core.json.JsonArray;
import org.apache.solr.common.SolrDocument;
import java.util.List;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.commons.lang3.math.NumberUtils;
import java.util.Optional;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.apache.solr.client.solrj.util.ClientUtils;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import org.apache.solr.common.SolrInputDocument;
import org.apache.commons.lang3.exception.ExceptionUtils;

/**	
 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstClasse_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.nico.enus.enrollment.SiteEnrollment&fq=classeEtendGen_indexed_boolean:true">Find the class  in Solr. </a>
 * <br/>
 **/
public abstract class SiteEnrollmentGen<DEV> extends Cluster {
	protected static final Logger LOGGER = LoggerFactory.getLogger(SiteEnrollment.class);

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
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected Long enrollmentKey;
	@JsonIgnore
	public Wrap<Long> enrollmentKeyWrap = new Wrap<Long>().p(this).c(Long.class).var("enrollmentKey").o(enrollmentKey);

	/**	<br/> The entity enrollmentKey
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.nico.enus.enrollment.SiteEnrollment&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:enrollmentKey">Find the entity enrollmentKey in Solr</a>
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

	public String nomAffichageEnrollmentKey() {
		return null;
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
	@JsonSerialize(contentUsing = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected List<Long> userKeys = new ArrayList<Long>();
	@JsonIgnore
	public Wrap<List<Long>> userKeysWrap = new Wrap<List<Long>>().p(this).c(List.class).var("userKeys").o(userKeys);

	/**	<br/> The entity userKeys
	 *  It is constructed before being initialized with the constructor by default List<Long>(). 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.nico.enus.enrollment.SiteEnrollment&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:userKeys">Find the entity userKeys in Solr</a>
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

	public String nomAffichageUserKeys() {
		return "users";
	}

	public String htmTooltipUserKeys() {
		return null;
	}

	public String htmUserKeys() {
		return userKeys == null ? "" : StringEscapeUtils.escapeHtml4(strUserKeys());
	}

	public void inputUserKeys(String classApiMethodMethod) {
		SiteEnrollment s = (SiteEnrollment)this;
		if(
				userKeys.contains(siteRequest_.getUserKey())
				|| Objects.equals(sessionId, siteRequest_.getSessionId())
				|| CollectionUtils.containsAny(siteRequest_.getUserResourceRoles(), ROLES)
				|| CollectionUtils.containsAny(siteRequest_.getUserRealmRoles(), ROLES)
		) {
			e("i").a("class", "far fa-search w3-xxlarge w3-cell w3-cell-middle ").f().g("i");
			if("PUTCopy".equals(classApiMethodMethod)) {
				{ e("div").f();
					e("input")
						.a("type", "checkbox")
						.a("id", classApiMethodMethod, "_userKeys_clear")
						.a("class", "userKeys_clear ")
						.fg();
					e("label").a("for", "classApiMethodMethod, \"_userKeys_clear").f().sx("clear").g("label");
				} g("div");
			}
			e("input")
				.a("type", "text")
				.a("placeholder", "users")
				.a("class", "valueObjectSuggest suggestUserKeys w3-input w3-border w3-cell w3-cell-middle ")
				.a("name", "setUserKeys")
				.a("id", classApiMethodMethod, "_userKeys")
				.a("autocomplete", "off");
				a("oninput", "suggestSiteEnrollmentUserKeys($(this).val() ? [ { 'name': 'q', 'value': 'objectSuggest:' + $(this).val() }, { 'name': 'rows', 'value': '10' }, { 'name': 'fl', 'value': 'pk,pageUrlPk,objectTitle' } ] : [", pk == null ? "" : "{'name':'fq','value':'enrollmentKeys:" + pk + "'}", "], $('#listSiteEnrollmentUserKeys_", classApiMethodMethod, "'), ", pk, "); ");

				fg();

		} else {
		}
	}

	public void htmUserKeys(String classApiMethodMethod) {
		SiteEnrollment s = (SiteEnrollment)this;
		{ e("div").a("class", "w3-cell w3-cell-top w3-center w3-mobile ").f();
			{ e("div").a("class", "w3-padding ").f();
				{ e("div").a("id", "suggest", classApiMethodMethod, "SiteEnrollmentUserKeys").f();
					{ e("div").a("class", "w3-card ").f();
						{ e("div").a("class", "w3-cell-row ").f();
							{ e("a").a("href", "/user?fq=enrollmentKeys:", pk).a("class", "w3-cell w3-btn w3-center h4 w3-block h4 w3-gray w3-hover-gray ").f();
								e("i").a("class", "fad fa-house-user ").f().g("i");
								sx("users");
							} g("a");
						} g("div");
						{ e("div").a("class", "w3-cell-row ").f();
							{ e("h5").a("class", "w3-cell ").f();
								sx("relate  to this enrollment");
							} g("h5");
						} g("div");
						{ e("div").a("class", "w3-cell-row w3-padding ").f();
							{ e("div").a("class", "w3-cell ").f();
								{ e("div").a("class", "w3-cell-row ").f();

								inputUserKeys(classApiMethodMethod);
								} g("div");
							} g("div");
						} g("div");
						{ e("div").a("class", "w3-cell-row w3-padding ").f();
							{ e("div").a("class", "w3-cell w3-left-align w3-cell-top ").f();
								{ e("ul").a("class", "w3-ul w3-hoverable ").a("id", "listSiteEnrollmentUserKeys_", classApiMethodMethod).f();
								} g("ul");
								if(
										CollectionUtils.containsAny(siteRequest_.getUserResourceRoles(), SiteUser.ROLES)
										|| CollectionUtils.containsAny(siteRequest_.getUserRealmRoles(), SiteUser.ROLES)
										) {
									if("Page".equals(classApiMethodMethod)) {
										{ e("div").a("class", "w3-cell-row ").f();
											e("button")
												.a("class", "w3-btn w3-round w3-border w3-border-black w3-ripple w3-padding w3-gray ")
												.a("id", classApiMethodMethod, "_userKeys_add")
												.a("onclick", "$(this).addClass('w3-disabled'); this.disabled = true; this.innerHTML = 'Sending…'; postSiteUserVals({ enrollmentKeys: [ \"", pk, "\" ] }, function() {}, function() { addError($('#", classApiMethodMethod, "userKeys')); });")
												.f().sx("add a site user")
											.g("button");
										} g("div");
									}
								}
							} g("div");
						} g("div");
					} g("div");
				} g("div");
			} g("div");
		} g("div");
	}

	/////////////
	// petKeys //
	/////////////

	/**	 The entity petKeys
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut List<Long>(). 
	 */
	@JsonSerialize(contentUsing = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected List<Long> petKeys = new ArrayList<Long>();
	@JsonIgnore
	public Wrap<List<Long>> petKeysWrap = new Wrap<List<Long>>().p(this).c(List.class).var("petKeys").o(petKeys);

	/**	<br/> The entity petKeys
	 *  It is constructed before being initialized with the constructor by default List<Long>(). 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.nico.enus.enrollment.SiteEnrollment&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:petKeys">Find the entity petKeys in Solr</a>
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

	public String nomAffichagePetKeys() {
		return "pets";
	}

	public String htmTooltipPetKeys() {
		return null;
	}

	public String htmPetKeys() {
		return petKeys == null ? "" : StringEscapeUtils.escapeHtml4(strPetKeys());
	}

	public void inputPetKeys(String classApiMethodMethod) {
		SiteEnrollment s = (SiteEnrollment)this;
		if(
				userKeys.contains(siteRequest_.getUserKey())
				|| Objects.equals(sessionId, siteRequest_.getSessionId())
				|| CollectionUtils.containsAny(siteRequest_.getUserResourceRoles(), ROLES)
				|| CollectionUtils.containsAny(siteRequest_.getUserRealmRoles(), ROLES)
		) {
			e("i").a("class", "far fa-search w3-xxlarge w3-cell w3-cell-middle ").f().g("i");
			if("PUTCopy".equals(classApiMethodMethod)) {
				{ e("div").f();
					e("input")
						.a("type", "checkbox")
						.a("id", classApiMethodMethod, "_petKeys_clear")
						.a("class", "petKeys_clear ")
						.fg();
					e("label").a("for", "classApiMethodMethod, \"_petKeys_clear").f().sx("clear").g("label");
				} g("div");
			}
			e("input")
				.a("type", "text")
				.a("placeholder", "pets")
				.a("class", "valueObjectSuggest suggestPetKeys w3-input w3-border w3-cell w3-cell-middle ")
				.a("name", "setPetKeys")
				.a("id", classApiMethodMethod, "_petKeys")
				.a("autocomplete", "off");
				a("oninput", "suggestSiteEnrollmentPetKeys($(this).val() ? [ { 'name': 'q', 'value': 'objectSuggest:' + $(this).val() }, { 'name': 'rows', 'value': '10' }, { 'name': 'fl', 'value': 'pk,pageUrlPk,objectTitle' } ] : [", pk == null ? "" : "{'name':'fq','value':'enrollmentKeys:" + pk + "'}", "], $('#listSiteEnrollmentPetKeys_", classApiMethodMethod, "'), ", pk, "); ");

				fg();

		} else {
		}
	}

	public void htmPetKeys(String classApiMethodMethod) {
		SiteEnrollment s = (SiteEnrollment)this;
		{ e("div").a("class", "w3-cell w3-cell-top w3-center w3-mobile ").f();
			{ e("div").a("class", "w3-padding ").f();
				{ e("div").a("id", "suggest", classApiMethodMethod, "SiteEnrollmentPetKeys").f();
					{ e("div").a("class", "w3-card ").f();
						{ e("div").a("class", "w3-cell-row ").f();
							{ e("a").a("href", "/pet?fq=enrollmentKeys:", pk).a("class", "w3-cell w3-btn w3-center h4 w3-block h4 w3-pale-green w3-hover-pale-green ").f();
								e("i").a("class", "fas fa-dog ").f().g("i");
								sx("pets");
							} g("a");
						} g("div");
						{ e("div").a("class", "w3-cell-row ").f();
							{ e("h5").a("class", "w3-cell ").f();
								sx("relate  to this enrollment");
							} g("h5");
						} g("div");
						{ e("div").a("class", "w3-cell-row w3-padding ").f();
							{ e("div").a("class", "w3-cell ").f();
								{ e("div").a("class", "w3-cell-row ").f();

								inputPetKeys(classApiMethodMethod);
								} g("div");
							} g("div");
						} g("div");
						{ e("div").a("class", "w3-cell-row w3-padding ").f();
							{ e("div").a("class", "w3-cell w3-left-align w3-cell-top ").f();
								{ e("ul").a("class", "w3-ul w3-hoverable ").a("id", "listSiteEnrollmentPetKeys_", classApiMethodMethod).f();
								} g("ul");
								{
									if("Page".equals(classApiMethodMethod)) {
										{ e("div").a("class", "w3-cell-row ").f();
											e("button")
												.a("class", "w3-btn w3-round w3-border w3-border-black w3-ripple w3-padding w3-pale-green ")
												.a("id", classApiMethodMethod, "_petKeys_add")
												.a("onclick", "$(this).addClass('w3-disabled'); this.disabled = true; this.innerHTML = 'Sending…'; postSitePetVals({ enrollmentKeys: [ \"", pk, "\" ] }, function() {}, function() { addError($('#", classApiMethodMethod, "petKeys')); });")
												.f().sx("add a pet")
											.g("button");
										} g("div");
									}
								}
							} g("div");
						} g("div");
					} g("div");
				} g("div");
			} g("div");
		} g("div");
	}

	///////////////
	// petSearch //
	///////////////

	/**	 The entity petSearch
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut SearchList<SitePet>(). 
	 */
	@JsonIgnore
	@JsonInclude(Include.NON_NULL)
	protected SearchList<SitePet> petSearch = new SearchList<SitePet>();
	@JsonIgnore
	public Wrap<SearchList<SitePet>> petSearchWrap = new Wrap<SearchList<SitePet>>().p(this).c(SearchList.class).var("petSearch").o(petSearch);

	/**	<br/> The entity petSearch
	 *  It is constructed before being initialized with the constructor by default SearchList<SitePet>(). 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.nico.enus.enrollment.SiteEnrollment&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:petSearch">Find the entity petSearch in Solr</a>
	 * <br/>
	 * @param petSearch is the entity already constructed. 
	 **/
	protected abstract void _petSearch(SearchList<SitePet> l);

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
	protected SiteEnrollment petSearchInit() {
		if(!petSearchWrap.alreadyInitialized) {
			_petSearch(petSearch);
		}
		petSearch.initDeepForClass(siteRequest_);
		petSearchWrap.alreadyInitialized(true);
		return (SiteEnrollment)this;
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
	public Wrap<SitePet> pet_Wrap = new Wrap<SitePet>().p(this).c(SitePet.class).var("pet_").o(pet_);

	/**	<br/> The entity pet_
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.nico.enus.enrollment.SiteEnrollment&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:pet_">Find the entity pet_ in Solr</a>
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
		}
		pet_Wrap.alreadyInitialized(true);
		return (SiteEnrollment)this;
	}

	//////////////
	// initDeep //
	//////////////

	protected boolean alreadyInitializedSiteEnrollment = false;

	public SiteEnrollment initDeepSiteEnrollment(SiteRequestEnUS siteRequest_) {
		setSiteRequest_(siteRequest_);
		if(!alreadyInitializedSiteEnrollment) {
			alreadyInitializedSiteEnrollment = true;
			initDeepSiteEnrollment();
		}
		return (SiteEnrollment)this;
	}

	public void initDeepSiteEnrollment() {
		initSiteEnrollment();
		super.initDeepCluster(siteRequest_);
	}

	public void initSiteEnrollment() {
		enrollmentKeyInit();
		userKeysInit();
		petKeysInit();
		petSearchInit();
		pet_Init();
	}

	@Override public void initDeepForClass(SiteRequestEnUS siteRequest_) {
		initDeepSiteEnrollment(siteRequest_);
	}

	/////////////////
	// siteRequest //
	/////////////////

	public void siteRequestSiteEnrollment(SiteRequestEnUS siteRequest_) {
			super.siteRequestCluster(siteRequest_);
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
				return super.obtainCluster(var);
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
			else if(o instanceof Cluster) {
				Cluster cluster = (Cluster)o;
				o = cluster.attributeForClass(v, val);
			}
		}
		return o != null;
	}
	public Object attributeSiteEnrollment(String var, Object val) {
		SiteEnrollment oSiteEnrollment = (SiteEnrollment)this;
		switch(var) {
			case "userKeys":
				oSiteEnrollment.addUserKeys((Long)val);
				if(!saves.contains("userKeys"))
					saves.add("userKeys");
				return val;
			case "petKeys":
				oSiteEnrollment.addPetKeys((Long)val);
				if(!saves.contains("petKeys"))
					saves.add("petKeys");
				return val;
			default:
				return super.attributeCluster(var, val);
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
				return Cluster.staticSetCluster(entityVar,  siteRequest_, o);
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
				return Cluster.staticSolrCluster(entityVar,  siteRequest_, o);
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
				return Cluster.staticSolrStrCluster(entityVar,  siteRequest_, o);
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
				return Cluster.staticSolrFqCluster(entityVar,  siteRequest_, o);
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
				else if(o instanceof Cluster) {
					Cluster oCluster = (Cluster)o;
					o = oCluster.defineForClass(v, val);
				}
			}
		}
		return o != null;
	}
	public Object defineSiteEnrollment(String var, String val) {
		switch(var.toLowerCase()) {
			default:
				return super.defineCluster(var, val);
		}
	}

	@Override public boolean defineForClass(String var, Object val) {
		String[] vars = StringUtils.split(var, ".");
		Object o = null;
		if(val != null) {
			for(String v : vars) {
				if(o == null)
					o = defineSiteEnrollment(v, val);
				else if(o instanceof Cluster) {
					Cluster oCluster = (Cluster)o;
					o = oCluster.defineForClass(v, val);
				}
			}
		}
		return o != null;
	}
	public Object defineSiteEnrollment(String var, Object val) {
		switch(var.toLowerCase()) {
			default:
				return super.defineCluster(var, val);
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

			List<Long> userKeys = (List<Long>)solrDocument.get("userKeys_stored_longs");
			if(userKeys != null)
				oSiteEnrollment.userKeys.addAll(userKeys);

			List<Long> petKeys = (List<Long>)solrDocument.get("petKeys_stored_longs");
			if(petKeys != null)
				oSiteEnrollment.petKeys.addAll(petKeys);
		}

		super.populateCluster(solrDocument);
	}

	/////////////
	// index //
	/////////////

	public static void index() {
		try {
			SiteRequestEnUS siteRequest = new SiteRequestEnUS();
			siteRequest.initDeepSiteRequestEnUS();
			SiteContextEnUS siteContext = new SiteContextEnUS();
			siteContext.getSiteConfig().setConfigPath("/usr/local/src/nico-site/config/nico-site.config");
			siteContext.initDeepSiteContextEnUS();
			siteRequest.setSiteContext_(siteContext);
			siteRequest.setSiteConfig_(siteContext.getSiteConfig());
			SolrQuery solrQuery = new SolrQuery();
			solrQuery.setQuery("*:*");
			solrQuery.setRows(1);
			solrQuery.addFilterQuery("id:" + ClientUtils.escapeQueryChars("org.computate.nico.enus.enrollment.SiteEnrollment"));
			QueryResponse queryResponse = siteRequest.getSiteContext_().getSolrClient().query(solrQuery);
			if(queryResponse.getResults().size() > 0)
				siteRequest.setSolrDocument(queryResponse.getResults().get(0));
			SiteEnrollment o = new SiteEnrollment();
			o.siteRequestSiteEnrollment(siteRequest);
			o.initDeepSiteEnrollment(siteRequest);
			o.indexSiteEnrollment();
		} catch(Exception e) {
			ExceptionUtils.rethrow(e);
		}
	}


	@Override public void indexForClass() {
		indexSiteEnrollment();
	}

	@Override public void indexForClass(SolrInputDocument document) {
		indexSiteEnrollment(document);
	}

	public void indexSiteEnrollment(SolrClient clientSolr) {
		try {
			SolrInputDocument document = new SolrInputDocument();
			indexSiteEnrollment(document);
			clientSolr.add(document);
			clientSolr.commit(false, false, true);
		} catch(Exception e) {
			ExceptionUtils.rethrow(e);
		}
	}

	public void indexSiteEnrollment() {
		try {
			SolrInputDocument document = new SolrInputDocument();
			indexSiteEnrollment(document);
			SolrClient clientSolr = siteRequest_.getSiteContext_().getSolrClient();
			clientSolr.add(document);
			clientSolr.commit(false, false, true);
		} catch(Exception e) {
			ExceptionUtils.rethrow(e);
		}
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
		super.indexCluster(document);

	}

	public void unindexSiteEnrollment() {
		try {
		SiteRequestEnUS siteRequest = new SiteRequestEnUS();
			siteRequest.initDeepSiteRequestEnUS();
			SiteContextEnUS siteContext = new SiteContextEnUS();
			siteContext.initDeepSiteContextEnUS();
			siteRequest.setSiteContext_(siteContext);
			siteRequest.setSiteConfig_(siteContext.getSiteConfig());
			initDeepSiteEnrollment(siteRequest);
			SolrClient solrClient = siteContext.getSolrClient();
			solrClient.deleteById(id.toString());
			solrClient.commit(false, false, true);
		} catch(Exception e) {
			ExceptionUtils.rethrow(e);
		}
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
				return Cluster.varIndexedCluster(entityVar);
		}
	}

	public static String varSearchSiteEnrollment(String entityVar) {
		switch(entityVar) {
			default:
				return Cluster.varSearchCluster(entityVar);
		}
	}

	public static String varSuggestedSiteEnrollment(String entityVar) {
		switch(entityVar) {
			default:
				return Cluster.varSuggestedCluster(entityVar);
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

		Long enrollmentKey = (Long)solrDocument.get("enrollmentKey_stored_long");
		if(enrollmentKey != null)
			oSiteEnrollment.setEnrollmentKey(enrollmentKey);

		List<Long> userKeys = (List<Long>)solrDocument.get("userKeys_stored_longs");
		if(userKeys != null)
			oSiteEnrollment.userKeys.addAll(userKeys);

		List<Long> petKeys = (List<Long>)solrDocument.get("petKeys_stored_longs");
		if(petKeys != null)
			oSiteEnrollment.petKeys.addAll(petKeys);

		super.storeCluster(solrDocument);
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
			super.apiRequestCluster();
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
}
