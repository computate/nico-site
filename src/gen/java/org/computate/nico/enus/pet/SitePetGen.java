package org.computate.nico.enus.pet;

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
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.lang.Boolean;
import io.vertx.core.json.JsonObject;
import java.lang.String;
import io.vertx.core.logging.Logger;
import org.computate.nico.enus.wrap.Wrap;
import java.math.RoundingMode;
import org.computate.nico.enus.cluster.Cluster;
import java.math.MathContext;
import org.apache.solr.client.solrj.response.QueryResponse;
import java.util.Set;
import org.apache.commons.text.StringEscapeUtils;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.computate.nico.enus.request.api.ApiRequest;
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
 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstClasse_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.nico.enus.pet.SitePet&fq=classeEtendGen_indexed_boolean:true">Find the class  in Solr. </a>
 * <br/>
 **/
public abstract class SitePetGen<DEV> extends Cluster {
	protected static final Logger LOGGER = LoggerFactory.getLogger(SitePet.class);

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
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected Long petKey;
	@JsonIgnore
	public Wrap<Long> petKeyWrap = new Wrap<Long>().p(this).c(Long.class).var("petKey").o(petKey);

	/**	<br/> The entity petKey
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.nico.enus.pet.SitePet&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:petKey">Find the entity petKey in Solr</a>
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

	public String jsonPetKey() {
		return petKey == null ? "" : petKey.toString();
	}

	public String nomAffichagePetKey() {
		return null;
	}

	public String htmTooltipPetKey() {
		return null;
	}

	public String htmPetKey() {
		return petKey == null ? "" : StringEscapeUtils.escapeHtml4(strPetKey());
	}

	/////////////
	// petName //
	/////////////

	/**	 The entity petName
	 *	 is defined as null before being initialized. 
	 */
	@JsonInclude(Include.NON_NULL)
	protected String petName;
	@JsonIgnore
	public Wrap<String> petNameWrap = new Wrap<String>().p(this).c(String.class).var("petName").o(petName);

	/**	<br/> The entity petName
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.nico.enus.pet.SitePet&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:petName">Find the entity petName in Solr</a>
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

	public String jsonPetName() {
		return petName == null ? "" : petName;
	}

	public String nomAffichagePetName() {
		return "name of pet:";
	}

	public String htmTooltipPetName() {
		return null;
	}

	public String htmPetName() {
		return petName == null ? "" : StringEscapeUtils.escapeHtml4(strPetName());
	}

	public void inputPetName(String classApiMethodMethod) {
		SitePet s = (SitePet)this;
		if(
				CollectionUtils.containsAny(siteRequest_.getUserResourceRoles(), ROLES)
				|| CollectionUtils.containsAny(siteRequest_.getUserRealmRoles(), ROLES)
				) {
			e("input")
				.a("type", "text")
				.a("placeholder", "name of pet:")
				.a("id", classApiMethodMethod, "_petName");
				if("Page".equals(classApiMethodMethod) || "PATCH".equals(classApiMethodMethod)) {
					a("class", "setPetName classSitePet inputSitePet", pk, "PetName w3-input w3-border ");
					a("name", "setPetName");
				} else {
					a("class", "valuePetName w3-input w3-border classSitePet inputSitePet", pk, "PetName w3-input w3-border ");
					a("name", "petName");
				}
				if("Page".equals(classApiMethodMethod)) {
					a("onclick", "removeGlow($(this)); ");
					a("onchange", "patch", getClass().getSimpleName(), "Val([{ name: 'fq', value: 'pk:", pk, "' }], 'setPetName', $(this).val(), function() { addGlow($('#", classApiMethodMethod, "_petName')); }, function() { addError($('#", classApiMethodMethod, "_petName')); }); ");
				}
				a("value", strPetName())
			.fg();

		} else {
			e("span").a("class", "varSitePet", pk, "PetName ").f().sx(htmPetName()).g("span");
		}
	}

	public void htmPetName(String classApiMethodMethod) {
		SitePet s = (SitePet)this;
		{ e("div").a("class", "w3-cell w3-cell-top w3-center w3-mobile ").f();
			{ e("div").a("class", "w3-padding ").f();
				{ e("div").a("id", "suggest", classApiMethodMethod, "SitePetPetName").f();
					{ e("div").a("class", "w3-card ").f();
						{ e("div").a("class", "w3-cell-row w3-pale-green ").f();
							e("label").a("for", classApiMethodMethod, "_petName").a("class", "").f().sx("name of pet:").g("label");
						} g("div");
						{ e("div").a("class", "w3-cell-row w3-padding ").f();
							{ e("div").a("class", "w3-cell ").f();

								inputPetName(classApiMethodMethod);
							} g("div");
							if(
									CollectionUtils.containsAny(siteRequest_.getUserResourceRoles(), ROLES)
									|| CollectionUtils.containsAny(siteRequest_.getUserRealmRoles(), ROLES)
									) {
								if("Page".equals(classApiMethodMethod)) {
									{ e("div").a("class", "w3-cell w3-left-align w3-cell-top ").f();
										{ e("button")
											.a("tabindex", "-1")
											.a("class", "w3-btn w3-round w3-border w3-border-black w3-ripple w3-padding w3-bar-item w3-pale-green ")
										.a("onclick", "removeGlow($('#", classApiMethodMethod, "_petName')); $('#", classApiMethodMethod, "_petName').val(null); patch", getClass().getSimpleName(), "Val([{ name: 'fq', value: 'pk:' + $('#SitePetForm :input[name=pk]').val() }], 'setPetName', null, function() { addGlow($('#", classApiMethodMethod, "_petName')); }, function() { addError($('#", classApiMethodMethod, "_petName')); }); ")
											.f();
											e("i").a("class", "far fa-eraser ").f().g("i");
										} g("button");
									} g("div");
								}
							}
						} g("div");
					} g("div");
				} g("div");
			} g("div");
		} g("div");
	}

	///////////////////
	// petFoodAmount //
	///////////////////

	/**	 The entity petFoodAmount
	 *	 is defined as null before being initialized. 
	 */
	@JsonInclude(Include.NON_NULL)
	protected String petFoodAmount;
	@JsonIgnore
	public Wrap<String> petFoodAmountWrap = new Wrap<String>().p(this).c(String.class).var("petFoodAmount").o(petFoodAmount);

	/**	<br/> The entity petFoodAmount
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.nico.enus.pet.SitePet&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:petFoodAmount">Find the entity petFoodAmount in Solr</a>
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

	public String jsonPetFoodAmount() {
		return petFoodAmount == null ? "" : petFoodAmount;
	}

	public String nomAffichagePetFoodAmount() {
		return "How much does your pet eat?";
	}

	public String htmTooltipPetFoodAmount() {
		return null;
	}

	public String htmPetFoodAmount() {
		return petFoodAmount == null ? "" : StringEscapeUtils.escapeHtml4(strPetFoodAmount());
	}

	public void inputPetFoodAmount(String classApiMethodMethod) {
		SitePet s = (SitePet)this;
		if(
				CollectionUtils.containsAny(siteRequest_.getUserResourceRoles(), ROLES)
				|| CollectionUtils.containsAny(siteRequest_.getUserRealmRoles(), ROLES)
				) {
			e("textarea")
				.a("placeholder", "How much does your pet eat?")
				.a("id", classApiMethodMethod, "_petFoodAmount");
				if("Page".equals(classApiMethodMethod) || "PATCH".equals(classApiMethodMethod)) {
					a("class", "setPetFoodAmount classSitePet inputSitePet", pk, "PetFoodAmount w3-input w3-border ");
					a("name", "setPetFoodAmount");
				} else {
					a("class", "valuePetFoodAmount w3-input w3-border classSitePet inputSitePet", pk, "PetFoodAmount w3-input w3-border ");
					a("name", "petFoodAmount");
				}
				if("Page".equals(classApiMethodMethod)) {
					a("onclick", "removeGlow($(this)); ");
					a("onchange", "patch", getClass().getSimpleName(), "Val([{ name: 'fq', value: 'pk:", pk, "' }], 'setPetFoodAmount', $(this).val(), function() { addGlow($('#", classApiMethodMethod, "_petFoodAmount')); }, function() { addError($('#", classApiMethodMethod, "_petFoodAmount')); }); ");
				}
			f().sx(strPetFoodAmount()).g("textarea");

		} else {
			e("span").a("class", "varSitePet", pk, "PetFoodAmount ").f().sx(htmPetFoodAmount()).g("span");
		}
	}

	public void htmPetFoodAmount(String classApiMethodMethod) {
		SitePet s = (SitePet)this;
		{ e("div").a("class", "w3-cell w3-cell-top w3-center w3-mobile ").f();
			{ e("div").a("class", "w3-padding ").f();
				{ e("div").a("id", "suggest", classApiMethodMethod, "SitePetPetFoodAmount").f();
					{ e("div").a("class", "w3-card ").f();
						{ e("div").a("class", "w3-cell-row w3-pale-green ").f();
							e("label").a("for", classApiMethodMethod, "_petFoodAmount").a("class", "").f().sx("How much does your pet eat?").g("label");
						} g("div");
						{ e("div").a("class", "w3-cell-row w3-padding ").f();
							{ e("div").a("class", "w3-cell ").f();

								inputPetFoodAmount(classApiMethodMethod);
							} g("div");
							if(
									CollectionUtils.containsAny(siteRequest_.getUserResourceRoles(), ROLES)
									|| CollectionUtils.containsAny(siteRequest_.getUserRealmRoles(), ROLES)
									) {
								if("Page".equals(classApiMethodMethod)) {
									{ e("div").a("class", "w3-cell w3-left-align w3-cell-top ").f();
										{ e("button")
											.a("tabindex", "-1")
											.a("class", "w3-btn w3-round w3-border w3-border-black w3-ripple w3-padding w3-bar-item w3-pale-green ")
										.a("onclick", "removeGlow($('#", classApiMethodMethod, "_petFoodAmount')); $('#", classApiMethodMethod, "_petFoodAmount').val(null); patch", getClass().getSimpleName(), "Val([{ name: 'fq', value: 'pk:' + $('#SitePetForm :input[name=pk]').val() }], 'setPetFoodAmount', null, function() { addGlow($('#", classApiMethodMethod, "_petFoodAmount')); }, function() { addError($('#", classApiMethodMethod, "_petFoodAmount')); }); ")
											.f();
											e("i").a("class", "far fa-eraser ").f().g("i");
										} g("button");
									} g("div");
								}
							}
						} g("div");
					} g("div");
				} g("div");
			} g("div");
		} g("div");
	}

	/////////////
	// petFood //
	/////////////

	/**	 The entity petFood
	 *	 is defined as null before being initialized. 
	 */
	@JsonInclude(Include.NON_NULL)
	protected String petFood;
	@JsonIgnore
	public Wrap<String> petFoodWrap = new Wrap<String>().p(this).c(String.class).var("petFood").o(petFood);

	/**	<br/> The entity petFood
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.nico.enus.pet.SitePet&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:petFood">Find the entity petFood in Solr</a>
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

	public String jsonPetFood() {
		return petFood == null ? "" : petFood;
	}

	public String nomAffichagePetFood() {
		return "What does your pet eat?";
	}

	public String htmTooltipPetFood() {
		return null;
	}

	public String htmPetFood() {
		return petFood == null ? "" : StringEscapeUtils.escapeHtml4(strPetFood());
	}

	public void inputPetFood(String classApiMethodMethod) {
		SitePet s = (SitePet)this;
		if(
				CollectionUtils.containsAny(siteRequest_.getUserResourceRoles(), ROLES)
				|| CollectionUtils.containsAny(siteRequest_.getUserRealmRoles(), ROLES)
				) {
			e("textarea")
				.a("placeholder", "What does your pet eat?")
				.a("id", classApiMethodMethod, "_petFood");
				if("Page".equals(classApiMethodMethod) || "PATCH".equals(classApiMethodMethod)) {
					a("class", "setPetFood classSitePet inputSitePet", pk, "PetFood w3-input w3-border ");
					a("name", "setPetFood");
				} else {
					a("class", "valuePetFood w3-input w3-border classSitePet inputSitePet", pk, "PetFood w3-input w3-border ");
					a("name", "petFood");
				}
				if("Page".equals(classApiMethodMethod)) {
					a("onclick", "removeGlow($(this)); ");
					a("onchange", "patch", getClass().getSimpleName(), "Val([{ name: 'fq', value: 'pk:", pk, "' }], 'setPetFood', $(this).val(), function() { addGlow($('#", classApiMethodMethod, "_petFood')); }, function() { addError($('#", classApiMethodMethod, "_petFood')); }); ");
				}
			f().sx(strPetFood()).g("textarea");

		} else {
			e("span").a("class", "varSitePet", pk, "PetFood ").f().sx(htmPetFood()).g("span");
		}
	}

	public void htmPetFood(String classApiMethodMethod) {
		SitePet s = (SitePet)this;
		{ e("div").a("class", "w3-cell w3-cell-top w3-center w3-mobile ").f();
			{ e("div").a("class", "w3-padding ").f();
				{ e("div").a("id", "suggest", classApiMethodMethod, "SitePetPetFood").f();
					{ e("div").a("class", "w3-card ").f();
						{ e("div").a("class", "w3-cell-row w3-pale-green ").f();
							e("label").a("for", classApiMethodMethod, "_petFood").a("class", "").f().sx("What does your pet eat?").g("label");
						} g("div");
						{ e("div").a("class", "w3-cell-row w3-padding ").f();
							{ e("div").a("class", "w3-cell ").f();

								inputPetFood(classApiMethodMethod);
							} g("div");
							if(
									CollectionUtils.containsAny(siteRequest_.getUserResourceRoles(), ROLES)
									|| CollectionUtils.containsAny(siteRequest_.getUserRealmRoles(), ROLES)
									) {
								if("Page".equals(classApiMethodMethod)) {
									{ e("div").a("class", "w3-cell w3-left-align w3-cell-top ").f();
										{ e("button")
											.a("tabindex", "-1")
											.a("class", "w3-btn w3-round w3-border w3-border-black w3-ripple w3-padding w3-bar-item w3-pale-green ")
										.a("onclick", "removeGlow($('#", classApiMethodMethod, "_petFood')); $('#", classApiMethodMethod, "_petFood').val(null); patch", getClass().getSimpleName(), "Val([{ name: 'fq', value: 'pk:' + $('#SitePetForm :input[name=pk]').val() }], 'setPetFood', null, function() { addGlow($('#", classApiMethodMethod, "_petFood')); }, function() { addError($('#", classApiMethodMethod, "_petFood')); }); ")
											.f();
											e("i").a("class", "far fa-eraser ").f().g("i");
										} g("button");
									} g("div");
								}
							}
						} g("div");
					} g("div");
				} g("div");
			} g("div");
		} g("div");
	}

	/////////////
	// petSick //
	/////////////

	/**	 The entity petSick
	 *	 is defined as null before being initialized. 
	 */
	@JsonInclude(Include.NON_NULL)
	protected Boolean petSick;
	@JsonIgnore
	public Wrap<Boolean> petSickWrap = new Wrap<Boolean>().p(this).c(Boolean.class).var("petSick").o(petSick);

	/**	<br/> The entity petSick
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:10383/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.nico.enus.pet.SitePet&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:petSick">Find the entity petSick in Solr</a>
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

	public String jsonPetSick() {
		return petSick == null ? "" : petSick.toString();
	}

	public String nomAffichagePetSick() {
		return "Is your pet sick, or need medication?";
	}

	public String htmTooltipPetSick() {
		return null;
	}

	public String htmPetSick() {
		return petSick == null ? "" : StringEscapeUtils.escapeHtml4(strPetSick());
	}

	public void inputPetSick(String classApiMethodMethod) {
		SitePet s = (SitePet)this;
		if(
				CollectionUtils.containsAny(siteRequest_.getUserResourceRoles(), ROLES)
				|| CollectionUtils.containsAny(siteRequest_.getUserRealmRoles(), ROLES)
				) {
			if("Page".equals(classApiMethodMethod)) {
				e("input")
					.a("type", "checkbox")
					.a("id", classApiMethodMethod, "_petSick")
					.a("value", "true");
			} else {
				e("select")
					.a("id", classApiMethodMethod, "_petSick");
			}
			if("Page".equals(classApiMethodMethod) || "PATCH".equals(classApiMethodMethod)) {
				a("class", "setPetSick classSitePet inputSitePet", pk, "PetSick w3-input w3-border ");
				a("name", "setPetSick");
			} else {
				a("class", "valuePetSick classSitePet inputSitePet", pk, "PetSick w3-input w3-border ");
				a("name", "petSick");
			}
			if("Page".equals(classApiMethodMethod)) {
				a("onchange", "patch", getClass().getSimpleName(), "Val([{ name: 'fq', value: 'pk:", pk, "' }], 'setPetSick', $(this).prop('checked'), function() { addGlow($('#", classApiMethodMethod, "_petSick')); }, function() { addError($('#", classApiMethodMethod, "_petSick')); }); ");
			}
			if("Page".equals(classApiMethodMethod)) {
				if(getPetSick() != null && getPetSick())
					a("checked", "checked");
				fg();
			} else {
				f();
				e("option").a("value", "").a("selected", "selected").f().g("option");
				e("option").a("value", "true").f().sx("true").g("option");
				e("option").a("value", "false").f().sx("false").g("option");
				g("select");
			}

		} else {
			e("span").a("class", "varSitePet", pk, "PetSick ").f().sx(htmPetSick()).g("span");
		}
	}

	public void htmPetSick(String classApiMethodMethod) {
		SitePet s = (SitePet)this;
		{ e("div").a("class", "w3-cell w3-cell-top w3-center w3-mobile ").f();
			{ e("div").a("class", "w3-padding ").f();
				{ e("div").a("id", "suggest", classApiMethodMethod, "SitePetPetSick").f();
					{ e("div").a("class", "w3-card ").f();
						{ e("div").a("class", "w3-cell-row w3-pale-green ").f();
							e("label").a("for", classApiMethodMethod, "_petSick").a("class", "").f().sx("Is your pet sick, or need medication?").g("label");
						} g("div");
						{ e("div").a("class", "w3-cell-row w3-padding ").f();
							{ e("div").a("class", "w3-cell ").f();

								inputPetSick(classApiMethodMethod);
							} g("div");
						} g("div");
					} g("div");
				} g("div");
			} g("div");
		} g("div");
	}

	//////////////
	// initDeep //
	//////////////

	protected boolean alreadyInitializedSitePet = false;

	public SitePet initDeepSitePet(SiteRequestEnUS siteRequest_) {
		setSiteRequest_(siteRequest_);
		if(!alreadyInitializedSitePet) {
			alreadyInitializedSitePet = true;
			initDeepSitePet();
		}
		return (SitePet)this;
	}

	public void initDeepSitePet() {
		initSitePet();
		super.initDeepCluster(siteRequest_);
	}

	public void initSitePet() {
		petKeyInit();
		petNameInit();
		petFoodAmountInit();
		petFoodInit();
		petSickInit();
	}

	@Override public void initDeepForClass(SiteRequestEnUS siteRequest_) {
		initDeepSitePet(siteRequest_);
	}

	/////////////////
	// siteRequest //
	/////////////////

	public void siteRequestSitePet(SiteRequestEnUS siteRequest_) {
			super.siteRequestCluster(siteRequest_);
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
			else if(o instanceof Cluster) {
				Cluster cluster = (Cluster)o;
				o = cluster.obtainForClass(v);
			}
		}
		return o;
	}
	public Object obtainSitePet(String var) {
		SitePet oSitePet = (SitePet)this;
		switch(var) {
			case "petKey":
				return oSitePet.petKey;
			case "petName":
				return oSitePet.petName;
			case "petFoodAmount":
				return oSitePet.petFoodAmount;
			case "petFood":
				return oSitePet.petFood;
			case "petSick":
				return oSitePet.petSick;
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
				o = attributeSitePet(v, val);
			else if(o instanceof Cluster) {
				Cluster cluster = (Cluster)o;
				o = cluster.attributeForClass(v, val);
			}
		}
		return o != null;
	}
	public Object attributeSitePet(String var, Object val) {
		SitePet oSitePet = (SitePet)this;
		switch(var) {
			default:
				return super.attributeCluster(var, val);
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
		case "petName":
			return SitePet.staticSetPetName(siteRequest_, o);
		case "petFoodAmount":
			return SitePet.staticSetPetFoodAmount(siteRequest_, o);
		case "petFood":
			return SitePet.staticSetPetFood(siteRequest_, o);
		case "petSick":
			return SitePet.staticSetPetSick(siteRequest_, o);
			default:
				return Cluster.staticSetCluster(entityVar,  siteRequest_, o);
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
		case "petName":
			return SitePet.staticSolrPetName(siteRequest_, (String)o);
		case "petFoodAmount":
			return SitePet.staticSolrPetFoodAmount(siteRequest_, (String)o);
		case "petFood":
			return SitePet.staticSolrPetFood(siteRequest_, (String)o);
		case "petSick":
			return SitePet.staticSolrPetSick(siteRequest_, (Boolean)o);
			default:
				return Cluster.staticSolrCluster(entityVar,  siteRequest_, o);
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
		case "petName":
			return SitePet.staticSolrStrPetName(siteRequest_, (String)o);
		case "petFoodAmount":
			return SitePet.staticSolrStrPetFoodAmount(siteRequest_, (String)o);
		case "petFood":
			return SitePet.staticSolrStrPetFood(siteRequest_, (String)o);
		case "petSick":
			return SitePet.staticSolrStrPetSick(siteRequest_, (Boolean)o);
			default:
				return Cluster.staticSolrStrCluster(entityVar,  siteRequest_, o);
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
		case "petName":
			return SitePet.staticSolrFqPetName(siteRequest_, o);
		case "petFoodAmount":
			return SitePet.staticSolrFqPetFoodAmount(siteRequest_, o);
		case "petFood":
			return SitePet.staticSolrFqPetFood(siteRequest_, o);
		case "petSick":
			return SitePet.staticSolrFqPetSick(siteRequest_, o);
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
					o = defineSitePet(v, val);
				else if(o instanceof Cluster) {
					Cluster oCluster = (Cluster)o;
					o = oCluster.defineForClass(v, val);
				}
			}
		}
		return o != null;
	}
	public Object defineSitePet(String var, String val) {
		switch(var) {
			case "petName":
				if(val != null)
					setPetName(val);
				saves.add(var);
				return val;
			case "petFoodAmount":
				if(val != null)
					setPetFoodAmount(val);
				saves.add(var);
				return val;
			case "petFood":
				if(val != null)
					setPetFood(val);
				saves.add(var);
				return val;
			case "petSick":
				if(val != null)
					setPetSick(val);
				saves.add(var);
				return val;
			default:
				return super.defineCluster(var, val);
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
			solrQuery.addFilterQuery("id:" + ClientUtils.escapeQueryChars("org.computate.nico.enus.pet.SitePet"));
			QueryResponse queryResponse = siteRequest.getSiteContext_().getSolrClient().query(solrQuery);
			if(queryResponse.getResults().size() > 0)
				siteRequest.setSolrDocument(queryResponse.getResults().get(0));
			SitePet o = new SitePet();
			o.siteRequestSitePet(siteRequest);
			o.initDeepSitePet(siteRequest);
			o.indexSitePet();
		} catch(Exception e) {
			ExceptionUtils.rethrow(e);
		}
	}


	@Override public void indexForClass() {
		indexSitePet();
	}

	@Override public void indexForClass(SolrInputDocument document) {
		indexSitePet(document);
	}

	public void indexSitePet(SolrClient clientSolr) {
		try {
			SolrInputDocument document = new SolrInputDocument();
			indexSitePet(document);
			clientSolr.add(document);
			clientSolr.commit(false, false, true);
		} catch(Exception e) {
			ExceptionUtils.rethrow(e);
		}
	}

	public void indexSitePet() {
		try {
			SolrInputDocument document = new SolrInputDocument();
			indexSitePet(document);
			SolrClient clientSolr = siteRequest_.getSiteContext_().getSolrClient();
			clientSolr.add(document);
			clientSolr.commit(false, false, true);
		} catch(Exception e) {
			ExceptionUtils.rethrow(e);
		}
	}

	public void indexSitePet(SolrInputDocument document) {
		if(petKey != null) {
			document.addField("petKey_indexed_long", petKey);
			document.addField("petKey_stored_long", petKey);
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
		super.indexCluster(document);

	}

	public void unindexSitePet() {
		try {
		SiteRequestEnUS siteRequest = new SiteRequestEnUS();
			siteRequest.initDeepSiteRequestEnUS();
			SiteContextEnUS siteContext = new SiteContextEnUS();
			siteContext.initDeepSiteContextEnUS();
			siteRequest.setSiteContext_(siteContext);
			siteRequest.setSiteConfig_(siteContext.getSiteConfig());
			initDeepSitePet(siteRequest);
			SolrClient solrClient = siteContext.getSolrClient();
			solrClient.deleteById(id.toString());
			solrClient.commit(false, false, true);
		} catch(Exception e) {
			ExceptionUtils.rethrow(e);
		}
	}

	public static String varIndexedSitePet(String entityVar) {
		switch(entityVar) {
			case "petKey":
				return "petKey_indexed_long";
			case "petName":
				return "petName_indexed_string";
			case "petFoodAmount":
				return "petFoodAmount_indexed_string";
			case "petFood":
				return "petFood_indexed_string";
			case "petSick":
				return "petSick_indexed_boolean";
			default:
				return Cluster.varIndexedCluster(entityVar);
		}
	}

	public static String varSearchSitePet(String entityVar) {
		switch(entityVar) {
			default:
				return Cluster.varSearchCluster(entityVar);
		}
	}

	public static String varSuggestedSitePet(String entityVar) {
		switch(entityVar) {
			default:
				return Cluster.varSuggestedCluster(entityVar);
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

		Long petKey = (Long)solrDocument.get("petKey_stored_long");
		if(petKey != null)
			oSitePet.setPetKey(petKey);

		String petName = (String)solrDocument.get("petName_stored_string");
		if(petName != null)
			oSitePet.setPetName(petName);

		String petFoodAmount = (String)solrDocument.get("petFoodAmount_stored_string");
		if(petFoodAmount != null)
			oSitePet.setPetFoodAmount(petFoodAmount);

		String petFood = (String)solrDocument.get("petFood_stored_string");
		if(petFood != null)
			oSitePet.setPetFood(petFood);

		Boolean petSick = (Boolean)solrDocument.get("petSick_stored_boolean");
		if(petSick != null)
			oSitePet.setPetSick(petSick);

		super.storeCluster(solrDocument);
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
			if(!Objects.equals(petName, original.getPetName()))
				apiRequest.addVars("petName");
			if(!Objects.equals(petFoodAmount, original.getPetFoodAmount()))
				apiRequest.addVars("petFoodAmount");
			if(!Objects.equals(petFood, original.getPetFood()))
				apiRequest.addVars("petFood");
			if(!Objects.equals(petSick, original.getPetSick()))
				apiRequest.addVars("petSick");
			super.apiRequestCluster();
		}
	}

	//////////////
	// hashCode //
	//////////////

	@Override public int hashCode() {
		return Objects.hash(super.hashCode(), petKey, petName, petFoodAmount, petFood, petSick);
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
				&& Objects.equals( petName, that.petName )
				&& Objects.equals( petFoodAmount, that.petFoodAmount )
				&& Objects.equals( petFood, that.petFood )
				&& Objects.equals( petSick, that.petSick );
	}

	//////////////
	// toString //
	//////////////

	@Override public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString() + "\n");
		sb.append("SitePet { ");
		sb.append( "petKey: " ).append(petKey);
		sb.append( ", petName: \"" ).append(petName).append( "\"" );
		sb.append( ", petFoodAmount: \"" ).append(petFoodAmount).append( "\"" );
		sb.append( ", petFood: \"" ).append(petFood).append( "\"" );
		sb.append( ", petSick: " ).append(petSick);
		sb.append(" }");
		return sb.toString();
	}
}
