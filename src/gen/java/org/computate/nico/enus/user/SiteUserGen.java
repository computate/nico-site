package org.computate.nico.enus.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Arrays;
import java.util.Date;
import org.slf4j.LoggerFactory;
import org.apache.commons.lang3.StringUtils;
import org.computate.nico.enus.writer.AllWriter;
import java.lang.Long;
import java.util.Map;
import io.vertx.core.json.JsonObject;
import org.computate.nico.enus.base.BaseModel;
import java.math.RoundingMode;
import org.computate.nico.enus.pet.SitePet;
import java.math.MathContext;
import java.util.Set;
import com.fasterxml.jackson.annotation.JsonFormat;
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
 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstClasse_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.nico.enus.user.SiteUser&fq=classeEtendGen_indexed_boolean:true">Find the class  in Solr. </a>
 * <br/>
 **/
public abstract class SiteUserGen<DEV> extends BaseModel {
	protected static final Logger LOG = LoggerFactory.getLogger(SiteUser.class);

	public static final String SiteUser_AName = "a site user";
	public static final String SiteUser_This = "this ";
	public static final String SiteUser_ThisName = "this site user";
	public static final String SiteUser_A = "a ";
	public static final String SiteUser_TheName = "the site user";
	public static final String SiteUser_NameSingular = "site user";
	public static final String SiteUser_NamePlural = "site users";
	public static final String SiteUser_NameActual = "current site user";
	public static final String SiteUser_AllName = "all the site users";
	public static final String SiteUser_SearchAllNameBy = "search site users by ";
	public static final String SiteUser_Title = "site users";
	public static final String SiteUser_ThePluralName = "the site users";
	public static final String SiteUser_NoNameFound = "no site user found";
	public static final String SiteUser_NameVar = "user";
	public static final String SiteUser_OfName = "of site user";
	public static final String SiteUser_ANameAdjective = "a site user";
	public static final String SiteUser_NameAdjectiveSingular = "site user";
	public static final String SiteUser_NameAdjectivePlural = "site users";
	public static final String SiteUser_Color = "gray";
	public static final String SiteUser_IconGroup = "regular";
	public static final String SiteUser_IconName = "user-cog";

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

	/**	<br/> The entity userKeys
	 *  It is constructed before being initialized with the constructor by default List<Long>(). 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.nico.enus.user.SiteUser&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:userKeys">Find the entity userKeys in Solr</a>
	 * <br/>
	 * @param userKeys is the entity already constructed. 
	 **/
	protected abstract void _userKeys(List<Long> l);

	public List<Long> getUserKeys() {
		return userKeys;
	}

	public void setUserKeys(List<Long> userKeys) {
		this.userKeys = userKeys;
	}
	@JsonIgnore
	public void setUserKeys(String o) {
		Long l = SiteUser.staticSetUserKeys(siteRequest_, o);
		if(l != null)
			addUserKeys(l);
	}
	public static Long staticSetUserKeys(SiteRequestEnUS siteRequest_, String o) {
		if(NumberUtils.isParsable(o))
			return Long.parseLong(o);
		return null;
	}
	public SiteUser addUserKeys(Long...objets) {
		for(Long o : objets) {
			addUserKeys(o);
		}
		return (SiteUser)this;
	}
	public SiteUser addUserKeys(Long o) {
		if(o != null && !userKeys.contains(o))
			this.userKeys.add(o);
		return (SiteUser)this;
	}
	@JsonIgnore
	public void setUserKeys(JsonArray objets) {
		userKeys.clear();
		for(int i = 0; i < objets.size(); i++) {
			Long o = objets.getLong(i);
			addUserKeys(o);
		}
	}
	public SiteUser addUserKeys(String o) {
		if(NumberUtils.isParsable(o)) {
			Long p = Long.parseLong(o);
			addUserKeys(p);
		}
		return (SiteUser)this;
	}
	protected SiteUser userKeysInit() {
		_userKeys(userKeys);
		return (SiteUser)this;
	}

	public static Long staticSolrUserKeys(SiteRequestEnUS siteRequest_, Long o) {
		return o;
	}

	public static String staticSolrStrUserKeys(SiteRequestEnUS siteRequest_, Long o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqUserKeys(SiteRequestEnUS siteRequest_, String o) {
		return SiteUser.staticSolrStrUserKeys(siteRequest_, SiteUser.staticSolrUserKeys(siteRequest_, SiteUser.staticSetUserKeys(siteRequest_, o)));
	}

	////////////
	// userId //
	////////////

	/**	 The entity userId
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String userId;

	/**	<br/> The entity userId
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.nico.enus.user.SiteUser&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:userId">Find the entity userId in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _userId(Wrap<String> c);

	public String getUserId() {
		return userId;
	}
	public void setUserId(String o) {
		this.userId = SiteUser.staticSetUserId(siteRequest_, o);
	}
	public static String staticSetUserId(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	protected SiteUser userIdInit() {
		Wrap<String> userIdWrap = new Wrap<String>().var("userId");
		if(userId == null) {
			_userId(userIdWrap);
			setUserId(userIdWrap.o);
		}
		return (SiteUser)this;
	}

	public static String staticSolrUserId(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSolrStrUserId(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqUserId(SiteRequestEnUS siteRequest_, String o) {
		return SiteUser.staticSolrStrUserId(siteRequest_, SiteUser.staticSolrUserId(siteRequest_, SiteUser.staticSetUserId(siteRequest_, o)));
	}

	public String sqlUserId() {
		return userId;
	}

	//////////////
	// userName //
	//////////////

	/**	 The entity userName
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String userName;

	/**	<br/> The entity userName
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.nico.enus.user.SiteUser&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:userName">Find the entity userName in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _userName(Wrap<String> c);

	public String getUserName() {
		return userName;
	}
	public void setUserName(String o) {
		this.userName = SiteUser.staticSetUserName(siteRequest_, o);
	}
	public static String staticSetUserName(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	protected SiteUser userNameInit() {
		Wrap<String> userNameWrap = new Wrap<String>().var("userName");
		if(userName == null) {
			_userName(userNameWrap);
			setUserName(userNameWrap.o);
		}
		return (SiteUser)this;
	}

	public static String staticSolrUserName(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSolrStrUserName(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqUserName(SiteRequestEnUS siteRequest_, String o) {
		return SiteUser.staticSolrStrUserName(siteRequest_, SiteUser.staticSolrUserName(siteRequest_, SiteUser.staticSetUserName(siteRequest_, o)));
	}

	public String sqlUserName() {
		return userName;
	}

	///////////////
	// userEmail //
	///////////////

	/**	 The entity userEmail
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String userEmail;

	/**	<br/> The entity userEmail
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.nico.enus.user.SiteUser&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:userEmail">Find the entity userEmail in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _userEmail(Wrap<String> c);

	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String o) {
		this.userEmail = SiteUser.staticSetUserEmail(siteRequest_, o);
	}
	public static String staticSetUserEmail(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	protected SiteUser userEmailInit() {
		Wrap<String> userEmailWrap = new Wrap<String>().var("userEmail");
		if(userEmail == null) {
			_userEmail(userEmailWrap);
			setUserEmail(userEmailWrap.o);
		}
		return (SiteUser)this;
	}

	public static String staticSolrUserEmail(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSolrStrUserEmail(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqUserEmail(SiteRequestEnUS siteRequest_, String o) {
		return SiteUser.staticSolrStrUserEmail(siteRequest_, SiteUser.staticSolrUserEmail(siteRequest_, SiteUser.staticSetUserEmail(siteRequest_, o)));
	}

	public String sqlUserEmail() {
		return userEmail;
	}

	///////////////////
	// userFirstName //
	///////////////////

	/**	 The entity userFirstName
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String userFirstName;

	/**	<br/> The entity userFirstName
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.nico.enus.user.SiteUser&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:userFirstName">Find the entity userFirstName in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _userFirstName(Wrap<String> c);

	public String getUserFirstName() {
		return userFirstName;
	}
	public void setUserFirstName(String o) {
		this.userFirstName = SiteUser.staticSetUserFirstName(siteRequest_, o);
	}
	public static String staticSetUserFirstName(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	protected SiteUser userFirstNameInit() {
		Wrap<String> userFirstNameWrap = new Wrap<String>().var("userFirstName");
		if(userFirstName == null) {
			_userFirstName(userFirstNameWrap);
			setUserFirstName(userFirstNameWrap.o);
		}
		return (SiteUser)this;
	}

	public static String staticSolrUserFirstName(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSolrStrUserFirstName(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqUserFirstName(SiteRequestEnUS siteRequest_, String o) {
		return SiteUser.staticSolrStrUserFirstName(siteRequest_, SiteUser.staticSolrUserFirstName(siteRequest_, SiteUser.staticSetUserFirstName(siteRequest_, o)));
	}

	public String sqlUserFirstName() {
		return userFirstName;
	}

	//////////////////
	// userLastName //
	//////////////////

	/**	 The entity userLastName
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String userLastName;

	/**	<br/> The entity userLastName
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.nico.enus.user.SiteUser&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:userLastName">Find the entity userLastName in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _userLastName(Wrap<String> c);

	public String getUserLastName() {
		return userLastName;
	}
	public void setUserLastName(String o) {
		this.userLastName = SiteUser.staticSetUserLastName(siteRequest_, o);
	}
	public static String staticSetUserLastName(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	protected SiteUser userLastNameInit() {
		Wrap<String> userLastNameWrap = new Wrap<String>().var("userLastName");
		if(userLastName == null) {
			_userLastName(userLastNameWrap);
			setUserLastName(userLastNameWrap.o);
		}
		return (SiteUser)this;
	}

	public static String staticSolrUserLastName(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSolrStrUserLastName(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqUserLastName(SiteRequestEnUS siteRequest_, String o) {
		return SiteUser.staticSolrStrUserLastName(siteRequest_, SiteUser.staticSolrUserLastName(siteRequest_, SiteUser.staticSetUserLastName(siteRequest_, o)));
	}

	public String sqlUserLastName() {
		return userLastName;
	}

	//////////////////
	// userFullName //
	//////////////////

	/**	 The entity userFullName
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String userFullName;

	/**	<br/> The entity userFullName
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.nico.enus.user.SiteUser&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:userFullName">Find the entity userFullName in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _userFullName(Wrap<String> c);

	public String getUserFullName() {
		return userFullName;
	}
	public void setUserFullName(String o) {
		this.userFullName = SiteUser.staticSetUserFullName(siteRequest_, o);
	}
	public static String staticSetUserFullName(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	protected SiteUser userFullNameInit() {
		Wrap<String> userFullNameWrap = new Wrap<String>().var("userFullName");
		if(userFullName == null) {
			_userFullName(userFullNameWrap);
			setUserFullName(userFullNameWrap.o);
		}
		return (SiteUser)this;
	}

	public static String staticSolrUserFullName(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSolrStrUserFullName(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqUserFullName(SiteRequestEnUS siteRequest_, String o) {
		return SiteUser.staticSolrStrUserFullName(siteRequest_, SiteUser.staticSolrUserFullName(siteRequest_, SiteUser.staticSetUserFullName(siteRequest_, o)));
	}

	public String sqlUserFullName() {
		return userFullName;
	}

	///////////////////////
	// userReceiveEmails //
	///////////////////////

	/**	 The entity userReceiveEmails
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected Boolean userReceiveEmails;

	/**	<br/> The entity userReceiveEmails
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.nico.enus.user.SiteUser&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:userReceiveEmails">Find the entity userReceiveEmails in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _userReceiveEmails(Wrap<Boolean> c);

	public Boolean getUserReceiveEmails() {
		return userReceiveEmails;
	}

	public void setUserReceiveEmails(Boolean userReceiveEmails) {
		this.userReceiveEmails = userReceiveEmails;
	}
	@JsonIgnore
	public void setUserReceiveEmails(String o) {
		this.userReceiveEmails = SiteUser.staticSetUserReceiveEmails(siteRequest_, o);
	}
	public static Boolean staticSetUserReceiveEmails(SiteRequestEnUS siteRequest_, String o) {
		return Boolean.parseBoolean(o);
	}
	protected SiteUser userReceiveEmailsInit() {
		Wrap<Boolean> userReceiveEmailsWrap = new Wrap<Boolean>().var("userReceiveEmails");
		if(userReceiveEmails == null) {
			_userReceiveEmails(userReceiveEmailsWrap);
			setUserReceiveEmails(userReceiveEmailsWrap.o);
		}
		return (SiteUser)this;
	}

	public static Boolean staticSolrUserReceiveEmails(SiteRequestEnUS siteRequest_, Boolean o) {
		return o;
	}

	public static String staticSolrStrUserReceiveEmails(SiteRequestEnUS siteRequest_, Boolean o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqUserReceiveEmails(SiteRequestEnUS siteRequest_, String o) {
		return SiteUser.staticSolrStrUserReceiveEmails(siteRequest_, SiteUser.staticSolrUserReceiveEmails(siteRequest_, SiteUser.staticSetUserReceiveEmails(siteRequest_, o)));
	}

	public Boolean sqlUserReceiveEmails() {
		return userReceiveEmails;
	}

	/////////////////
	// seeArchived //
	/////////////////

	/**	 The entity seeArchived
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected Boolean seeArchived;

	/**	<br/> The entity seeArchived
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.nico.enus.user.SiteUser&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:seeArchived">Find the entity seeArchived in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _seeArchived(Wrap<Boolean> c);

	public Boolean getSeeArchived() {
		return seeArchived;
	}

	public void setSeeArchived(Boolean seeArchived) {
		this.seeArchived = seeArchived;
	}
	@JsonIgnore
	public void setSeeArchived(String o) {
		this.seeArchived = SiteUser.staticSetSeeArchived(siteRequest_, o);
	}
	public static Boolean staticSetSeeArchived(SiteRequestEnUS siteRequest_, String o) {
		return Boolean.parseBoolean(o);
	}
	protected SiteUser seeArchivedInit() {
		Wrap<Boolean> seeArchivedWrap = new Wrap<Boolean>().var("seeArchived");
		if(seeArchived == null) {
			_seeArchived(seeArchivedWrap);
			setSeeArchived(seeArchivedWrap.o);
		}
		return (SiteUser)this;
	}

	public static Boolean staticSolrSeeArchived(SiteRequestEnUS siteRequest_, Boolean o) {
		return o;
	}

	public static String staticSolrStrSeeArchived(SiteRequestEnUS siteRequest_, Boolean o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqSeeArchived(SiteRequestEnUS siteRequest_, String o) {
		return SiteUser.staticSolrStrSeeArchived(siteRequest_, SiteUser.staticSolrSeeArchived(siteRequest_, SiteUser.staticSetSeeArchived(siteRequest_, o)));
	}

	public Boolean sqlSeeArchived() {
		return seeArchived;
	}

	////////////////
	// seeDeleted //
	////////////////

	/**	 The entity seeDeleted
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected Boolean seeDeleted;

	/**	<br/> The entity seeDeleted
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.nico.enus.user.SiteUser&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:seeDeleted">Find the entity seeDeleted in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _seeDeleted(Wrap<Boolean> c);

	public Boolean getSeeDeleted() {
		return seeDeleted;
	}

	public void setSeeDeleted(Boolean seeDeleted) {
		this.seeDeleted = seeDeleted;
	}
	@JsonIgnore
	public void setSeeDeleted(String o) {
		this.seeDeleted = SiteUser.staticSetSeeDeleted(siteRequest_, o);
	}
	public static Boolean staticSetSeeDeleted(SiteRequestEnUS siteRequest_, String o) {
		return Boolean.parseBoolean(o);
	}
	protected SiteUser seeDeletedInit() {
		Wrap<Boolean> seeDeletedWrap = new Wrap<Boolean>().var("seeDeleted");
		if(seeDeleted == null) {
			_seeDeleted(seeDeletedWrap);
			setSeeDeleted(seeDeletedWrap.o);
		}
		return (SiteUser)this;
	}

	public static Boolean staticSolrSeeDeleted(SiteRequestEnUS siteRequest_, Boolean o) {
		return o;
	}

	public static String staticSolrStrSeeDeleted(SiteRequestEnUS siteRequest_, Boolean o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqSeeDeleted(SiteRequestEnUS siteRequest_, String o) {
		return SiteUser.staticSolrStrSeeDeleted(siteRequest_, SiteUser.staticSolrSeeDeleted(siteRequest_, SiteUser.staticSetSeeDeleted(siteRequest_, o)));
	}

	public Boolean sqlSeeDeleted() {
		return seeDeleted;
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

	/**	<br/> The entity petKeys
	 *  It is constructed before being initialized with the constructor by default List<Long>(). 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.nico.enus.user.SiteUser&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:petKeys">Find the entity petKeys in Solr</a>
	 * <br/>
	 * @param petKeys is the entity already constructed. 
	 **/
	protected abstract void _petKeys(List<Long> c);

	public List<Long> getPetKeys() {
		return petKeys;
	}

	public void setPetKeys(List<Long> petKeys) {
		this.petKeys = petKeys;
	}
	@JsonIgnore
	public void setPetKeys(String o) {
		Long l = SiteUser.staticSetPetKeys(siteRequest_, o);
		if(l != null)
			addPetKeys(l);
	}
	public static Long staticSetPetKeys(SiteRequestEnUS siteRequest_, String o) {
		if(NumberUtils.isParsable(o))
			return Long.parseLong(o);
		return null;
	}
	public SiteUser addPetKeys(Long...objets) {
		for(Long o : objets) {
			addPetKeys(o);
		}
		return (SiteUser)this;
	}
	public SiteUser addPetKeys(Long o) {
		if(o != null && !petKeys.contains(o))
			this.petKeys.add(o);
		return (SiteUser)this;
	}
	@JsonIgnore
	public void setPetKeys(JsonArray objets) {
		petKeys.clear();
		for(int i = 0; i < objets.size(); i++) {
			Long o = objets.getLong(i);
			addPetKeys(o);
		}
	}
	public SiteUser addPetKeys(String o) {
		if(NumberUtils.isParsable(o)) {
			Long p = Long.parseLong(o);
			addPetKeys(p);
		}
		return (SiteUser)this;
	}
	protected SiteUser petKeysInit() {
		_petKeys(petKeys);
		return (SiteUser)this;
	}

	public static Long staticSolrPetKeys(SiteRequestEnUS siteRequest_, Long o) {
		return o;
	}

	public static String staticSolrStrPetKeys(SiteRequestEnUS siteRequest_, Long o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqPetKeys(SiteRequestEnUS siteRequest_, String o) {
		return SiteUser.staticSolrStrPetKeys(siteRequest_, SiteUser.staticSolrPetKeys(siteRequest_, SiteUser.staticSetPetKeys(siteRequest_, o)));
	}

	public List<Long> sqlPetKeys() {
		return petKeys;
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

	/**	<br/> The entity enrollmentKeys
	 *  It is constructed before being initialized with the constructor by default List<Long>(). 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.nico.enus.user.SiteUser&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:enrollmentKeys">Find the entity enrollmentKeys in Solr</a>
	 * <br/>
	 * @param enrollmentKeys is the entity already constructed. 
	 **/
	protected abstract void _enrollmentKeys(List<Long> c);

	public List<Long> getEnrollmentKeys() {
		return enrollmentKeys;
	}

	public void setEnrollmentKeys(List<Long> enrollmentKeys) {
		this.enrollmentKeys = enrollmentKeys;
	}
	@JsonIgnore
	public void setEnrollmentKeys(String o) {
		Long l = SiteUser.staticSetEnrollmentKeys(siteRequest_, o);
		if(l != null)
			addEnrollmentKeys(l);
	}
	public static Long staticSetEnrollmentKeys(SiteRequestEnUS siteRequest_, String o) {
		if(NumberUtils.isParsable(o))
			return Long.parseLong(o);
		return null;
	}
	public SiteUser addEnrollmentKeys(Long...objets) {
		for(Long o : objets) {
			addEnrollmentKeys(o);
		}
		return (SiteUser)this;
	}
	public SiteUser addEnrollmentKeys(Long o) {
		if(o != null && !enrollmentKeys.contains(o))
			this.enrollmentKeys.add(o);
		return (SiteUser)this;
	}
	@JsonIgnore
	public void setEnrollmentKeys(JsonArray objets) {
		enrollmentKeys.clear();
		for(int i = 0; i < objets.size(); i++) {
			Long o = objets.getLong(i);
			addEnrollmentKeys(o);
		}
	}
	public SiteUser addEnrollmentKeys(String o) {
		if(NumberUtils.isParsable(o)) {
			Long p = Long.parseLong(o);
			addEnrollmentKeys(p);
		}
		return (SiteUser)this;
	}
	protected SiteUser enrollmentKeysInit() {
		_enrollmentKeys(enrollmentKeys);
		return (SiteUser)this;
	}

	public static Long staticSolrEnrollmentKeys(SiteRequestEnUS siteRequest_, Long o) {
		return o;
	}

	public static String staticSolrStrEnrollmentKeys(SiteRequestEnUS siteRequest_, Long o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqEnrollmentKeys(SiteRequestEnUS siteRequest_, String o) {
		return SiteUser.staticSolrStrEnrollmentKeys(siteRequest_, SiteUser.staticSolrEnrollmentKeys(siteRequest_, SiteUser.staticSetEnrollmentKeys(siteRequest_, o)));
	}

	public List<Long> sqlEnrollmentKeys() {
		return enrollmentKeys;
	}

	//////////////
	// initDeep //
	//////////////

	public Future<Void> promiseDeepSiteUser(SiteRequestEnUS siteRequest_) {
		setSiteRequest_(siteRequest_);
		return promiseDeepSiteUser();
	}

	public Future<Void> promiseDeepSiteUser() {
		Promise<Void> promise = Promise.promise();
		Promise<Void> promise2 = Promise.promise();
		promiseSiteUser(promise2);
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

	public Future<Void> promiseSiteUser(Promise<Void> promise) {
		Future.future(a -> a.complete()).compose(a -> {
			Promise<Void> promise2 = Promise.promise();
			try {
				userKeysInit();
				userIdInit();
				userNameInit();
				userEmailInit();
				userFirstNameInit();
				userLastNameInit();
				userFullNameInit();
				userReceiveEmailsInit();
				seeArchivedInit();
				seeDeletedInit();
				petKeysInit();
				enrollmentKeysInit();
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
		return promiseDeepSiteUser(siteRequest_);
	}

	/////////////////
	// siteRequest //
	/////////////////

	public void siteRequestSiteUser(SiteRequestEnUS siteRequest_) {
			super.siteRequestBaseModel(siteRequest_);
	}

	public void siteRequestForClass(SiteRequestEnUS siteRequest_) {
		siteRequestSiteUser(siteRequest_);
	}

	/////////////
	// obtain //
	/////////////

	@Override public Object obtainForClass(String var) {
		String[] vars = StringUtils.split(var, ".");
		Object o = null;
		for(String v : vars) {
			if(o == null)
				o = obtainSiteUser(v);
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
	public Object obtainSiteUser(String var) {
		SiteUser oSiteUser = (SiteUser)this;
		switch(var) {
			case "userKeys":
				return oSiteUser.userKeys;
			case "userId":
				return oSiteUser.userId;
			case "userName":
				return oSiteUser.userName;
			case "userEmail":
				return oSiteUser.userEmail;
			case "userFirstName":
				return oSiteUser.userFirstName;
			case "userLastName":
				return oSiteUser.userLastName;
			case "userFullName":
				return oSiteUser.userFullName;
			case "userReceiveEmails":
				return oSiteUser.userReceiveEmails;
			case "seeArchived":
				return oSiteUser.seeArchived;
			case "seeDeleted":
				return oSiteUser.seeDeleted;
			case "petKeys":
				return oSiteUser.petKeys;
			case "enrollmentKeys":
				return oSiteUser.enrollmentKeys;
			default:
				return super.obtainBaseModel(var);
		}
	}

	///////////////
	// relate //
	///////////////

	@Override public boolean relateForClass(String var, Object val) {
		String[] vars = StringUtils.split(var, ".");
		Object o = null;
		for(String v : vars) {
			if(o == null)
				o = relateSiteUser(v, val);
			else if(o instanceof BaseModel) {
				BaseModel baseModel = (BaseModel)o;
				o = baseModel.relateForClass(v, val);
			}
		}
		return o != null;
	}
	public Object relateSiteUser(String var, Object val) {
		SiteUser oSiteUser = (SiteUser)this;
		switch(var) {
			case "petKeys":
				oSiteUser.addPetKeys((Long)val);
				if(!saves.contains("petKeys"))
					saves.add("petKeys");
				return val;
			case "enrollmentKeys":
				oSiteUser.addEnrollmentKeys((Long)val);
				if(!saves.contains("enrollmentKeys"))
					saves.add("enrollmentKeys");
				return val;
			default:
				return super.relateBaseModel(var, val);
		}
	}

	///////////////
	// staticSet //
	///////////////

	public static Object staticSetForClass(String entityVar, SiteRequestEnUS siteRequest_, String o) {
		return staticSetSiteUser(entityVar,  siteRequest_, o);
	}
	public static Object staticSetSiteUser(String entityVar, SiteRequestEnUS siteRequest_, String o) {
		switch(entityVar) {
		case "userKeys":
			return SiteUser.staticSetUserKeys(siteRequest_, o);
		case "userId":
			return SiteUser.staticSetUserId(siteRequest_, o);
		case "userName":
			return SiteUser.staticSetUserName(siteRequest_, o);
		case "userEmail":
			return SiteUser.staticSetUserEmail(siteRequest_, o);
		case "userFirstName":
			return SiteUser.staticSetUserFirstName(siteRequest_, o);
		case "userLastName":
			return SiteUser.staticSetUserLastName(siteRequest_, o);
		case "userFullName":
			return SiteUser.staticSetUserFullName(siteRequest_, o);
		case "userReceiveEmails":
			return SiteUser.staticSetUserReceiveEmails(siteRequest_, o);
		case "seeArchived":
			return SiteUser.staticSetSeeArchived(siteRequest_, o);
		case "seeDeleted":
			return SiteUser.staticSetSeeDeleted(siteRequest_, o);
		case "petKeys":
			return SiteUser.staticSetPetKeys(siteRequest_, o);
		case "enrollmentKeys":
			return SiteUser.staticSetEnrollmentKeys(siteRequest_, o);
			default:
				return BaseModel.staticSetBaseModel(entityVar,  siteRequest_, o);
		}
	}

	////////////////
	// staticSolr //
	////////////////

	public static Object staticSolrForClass(String entityVar, SiteRequestEnUS siteRequest_, Object o) {
		return staticSolrSiteUser(entityVar,  siteRequest_, o);
	}
	public static Object staticSolrSiteUser(String entityVar, SiteRequestEnUS siteRequest_, Object o) {
		switch(entityVar) {
		case "userKeys":
			return SiteUser.staticSolrUserKeys(siteRequest_, (Long)o);
		case "userId":
			return SiteUser.staticSolrUserId(siteRequest_, (String)o);
		case "userName":
			return SiteUser.staticSolrUserName(siteRequest_, (String)o);
		case "userEmail":
			return SiteUser.staticSolrUserEmail(siteRequest_, (String)o);
		case "userFirstName":
			return SiteUser.staticSolrUserFirstName(siteRequest_, (String)o);
		case "userLastName":
			return SiteUser.staticSolrUserLastName(siteRequest_, (String)o);
		case "userFullName":
			return SiteUser.staticSolrUserFullName(siteRequest_, (String)o);
		case "userReceiveEmails":
			return SiteUser.staticSolrUserReceiveEmails(siteRequest_, (Boolean)o);
		case "seeArchived":
			return SiteUser.staticSolrSeeArchived(siteRequest_, (Boolean)o);
		case "seeDeleted":
			return SiteUser.staticSolrSeeDeleted(siteRequest_, (Boolean)o);
		case "petKeys":
			return SiteUser.staticSolrPetKeys(siteRequest_, (Long)o);
		case "enrollmentKeys":
			return SiteUser.staticSolrEnrollmentKeys(siteRequest_, (Long)o);
			default:
				return BaseModel.staticSolrBaseModel(entityVar,  siteRequest_, o);
		}
	}

	///////////////////
	// staticSolrStr //
	///////////////////

	public static String staticSolrStrForClass(String entityVar, SiteRequestEnUS siteRequest_, Object o) {
		return staticSolrStrSiteUser(entityVar,  siteRequest_, o);
	}
	public static String staticSolrStrSiteUser(String entityVar, SiteRequestEnUS siteRequest_, Object o) {
		switch(entityVar) {
		case "userKeys":
			return SiteUser.staticSolrStrUserKeys(siteRequest_, (Long)o);
		case "userId":
			return SiteUser.staticSolrStrUserId(siteRequest_, (String)o);
		case "userName":
			return SiteUser.staticSolrStrUserName(siteRequest_, (String)o);
		case "userEmail":
			return SiteUser.staticSolrStrUserEmail(siteRequest_, (String)o);
		case "userFirstName":
			return SiteUser.staticSolrStrUserFirstName(siteRequest_, (String)o);
		case "userLastName":
			return SiteUser.staticSolrStrUserLastName(siteRequest_, (String)o);
		case "userFullName":
			return SiteUser.staticSolrStrUserFullName(siteRequest_, (String)o);
		case "userReceiveEmails":
			return SiteUser.staticSolrStrUserReceiveEmails(siteRequest_, (Boolean)o);
		case "seeArchived":
			return SiteUser.staticSolrStrSeeArchived(siteRequest_, (Boolean)o);
		case "seeDeleted":
			return SiteUser.staticSolrStrSeeDeleted(siteRequest_, (Boolean)o);
		case "petKeys":
			return SiteUser.staticSolrStrPetKeys(siteRequest_, (Long)o);
		case "enrollmentKeys":
			return SiteUser.staticSolrStrEnrollmentKeys(siteRequest_, (Long)o);
			default:
				return BaseModel.staticSolrStrBaseModel(entityVar,  siteRequest_, o);
		}
	}

	//////////////////
	// staticSolrFq //
	//////////////////

	public static String staticSolrFqForClass(String entityVar, SiteRequestEnUS siteRequest_, String o) {
		return staticSolrFqSiteUser(entityVar,  siteRequest_, o);
	}
	public static String staticSolrFqSiteUser(String entityVar, SiteRequestEnUS siteRequest_, String o) {
		switch(entityVar) {
		case "userKeys":
			return SiteUser.staticSolrFqUserKeys(siteRequest_, o);
		case "userId":
			return SiteUser.staticSolrFqUserId(siteRequest_, o);
		case "userName":
			return SiteUser.staticSolrFqUserName(siteRequest_, o);
		case "userEmail":
			return SiteUser.staticSolrFqUserEmail(siteRequest_, o);
		case "userFirstName":
			return SiteUser.staticSolrFqUserFirstName(siteRequest_, o);
		case "userLastName":
			return SiteUser.staticSolrFqUserLastName(siteRequest_, o);
		case "userFullName":
			return SiteUser.staticSolrFqUserFullName(siteRequest_, o);
		case "userReceiveEmails":
			return SiteUser.staticSolrFqUserReceiveEmails(siteRequest_, o);
		case "seeArchived":
			return SiteUser.staticSolrFqSeeArchived(siteRequest_, o);
		case "seeDeleted":
			return SiteUser.staticSolrFqSeeDeleted(siteRequest_, o);
		case "petKeys":
			return SiteUser.staticSolrFqPetKeys(siteRequest_, o);
		case "enrollmentKeys":
			return SiteUser.staticSolrFqEnrollmentKeys(siteRequest_, o);
			default:
				return BaseModel.staticSolrFqBaseModel(entityVar,  siteRequest_, o);
		}
	}

	/////////////
	// define //
	/////////////

	@Override public boolean defineForClass(String var, Object val) {
		String[] vars = StringUtils.split(var, ".");
		Object o = null;
		if(val != null) {
			for(String v : vars) {
				if(o == null)
					o = defineSiteUser(v, val);
				else if(o instanceof BaseModel) {
					BaseModel oBaseModel = (BaseModel)o;
					o = oBaseModel.defineForClass(v, val);
				}
			}
		}
		return o != null;
	}
	public Object defineSiteUser(String var, Object val) {
		switch(var.toLowerCase()) {
			case "userid":
				if(val instanceof String)
					setUserId((String)val);
				saves.add("userId");
				return val;
			case "username":
				if(val instanceof String)
					setUserName((String)val);
				saves.add("userName");
				return val;
			case "useremail":
				if(val instanceof String)
					setUserEmail((String)val);
				saves.add("userEmail");
				return val;
			case "userfirstname":
				if(val instanceof String)
					setUserFirstName((String)val);
				saves.add("userFirstName");
				return val;
			case "userlastname":
				if(val instanceof String)
					setUserLastName((String)val);
				saves.add("userLastName");
				return val;
			case "userfullname":
				if(val instanceof String)
					setUserFullName((String)val);
				saves.add("userFullName");
				return val;
			case "userreceiveemails":
				if(val instanceof Boolean)
					setUserReceiveEmails((Boolean)val);
				saves.add("userReceiveEmails");
				return val;
			case "seearchived":
				if(val instanceof Boolean)
					setSeeArchived((Boolean)val);
				saves.add("seeArchived");
				return val;
			case "seedeleted":
				if(val instanceof Boolean)
					setSeeDeleted((Boolean)val);
				saves.add("seeDeleted");
				return val;
			default:
				return super.defineBaseModel(var, val);
		}
	}

	/////////////
	// populate //
	/////////////

	@Override public void populateForClass(SolrDocument solrDocument) {
		populateSiteUser(solrDocument);
	}
	public void populateSiteUser(SolrDocument solrDocument) {
		SiteUser oSiteUser = (SiteUser)this;
		saves = (List<String>)solrDocument.get("saves_indexedstored_strings");
		if(saves != null) {

			if(saves.contains("userKeys")) {
				List<Long> userKeys = (List<Long>)solrDocument.get("userKeys_indexedstored_longs");
				if(userKeys != null)
					oSiteUser.userKeys.addAll(userKeys);
			}

			if(saves.contains("userId")) {
				String userId = (String)solrDocument.get("userId_indexedstored_string");
				if(userId != null)
					oSiteUser.setUserId(userId);
			}

			if(saves.contains("userName")) {
				String userName = (String)solrDocument.get("userName_indexedstored_string");
				if(userName != null)
					oSiteUser.setUserName(userName);
			}

			if(saves.contains("userEmail")) {
				String userEmail = (String)solrDocument.get("userEmail_indexedstored_string");
				if(userEmail != null)
					oSiteUser.setUserEmail(userEmail);
			}

			if(saves.contains("userFirstName")) {
				String userFirstName = (String)solrDocument.get("userFirstName_indexedstored_string");
				if(userFirstName != null)
					oSiteUser.setUserFirstName(userFirstName);
			}

			if(saves.contains("userLastName")) {
				String userLastName = (String)solrDocument.get("userLastName_indexedstored_string");
				if(userLastName != null)
					oSiteUser.setUserLastName(userLastName);
			}

			if(saves.contains("userFullName")) {
				String userFullName = (String)solrDocument.get("userFullName_indexedstored_string");
				if(userFullName != null)
					oSiteUser.setUserFullName(userFullName);
			}

			if(saves.contains("userReceiveEmails")) {
				Boolean userReceiveEmails = (Boolean)solrDocument.get("userReceiveEmails_indexedstored_boolean");
				if(userReceiveEmails != null)
					oSiteUser.setUserReceiveEmails(userReceiveEmails);
			}

			if(saves.contains("seeArchived")) {
				Boolean seeArchived = (Boolean)solrDocument.get("seeArchived_indexedstored_boolean");
				if(seeArchived != null)
					oSiteUser.setSeeArchived(seeArchived);
			}

			if(saves.contains("seeDeleted")) {
				Boolean seeDeleted = (Boolean)solrDocument.get("seeDeleted_indexedstored_boolean");
				if(seeDeleted != null)
					oSiteUser.setSeeDeleted(seeDeleted);
			}

			List<Long> petKeys = (List<Long>)solrDocument.get("petKeys_indexedstored_longs");
			if(petKeys != null)
				oSiteUser.petKeys.addAll(petKeys);

			List<Long> enrollmentKeys = (List<Long>)solrDocument.get("enrollmentKeys_indexedstored_longs");
			if(enrollmentKeys != null)
				oSiteUser.enrollmentKeys.addAll(enrollmentKeys);
		}

		super.populateBaseModel(solrDocument);
	}

	public void indexSiteUser(SolrInputDocument document) {
		if(userKeys != null) {
			for(java.lang.Long o : userKeys) {
				document.addField("userKeys_indexedstored_longs", o);
			}
		}
		if(userId != null) {
			document.addField("userId_indexedstored_string", userId);
		}
		if(userName != null) {
			document.addField("userName_indexedstored_string", userName);
		}
		if(userEmail != null) {
			document.addField("userEmail_indexedstored_string", userEmail);
		}
		if(userFirstName != null) {
			document.addField("userFirstName_indexedstored_string", userFirstName);
		}
		if(userLastName != null) {
			document.addField("userLastName_indexedstored_string", userLastName);
		}
		if(userFullName != null) {
			document.addField("userFullName_indexedstored_string", userFullName);
		}
		if(userReceiveEmails != null) {
			document.addField("userReceiveEmails_indexedstored_boolean", userReceiveEmails);
		}
		if(seeArchived != null) {
			document.addField("seeArchived_indexedstored_boolean", seeArchived);
		}
		if(seeDeleted != null) {
			document.addField("seeDeleted_indexedstored_boolean", seeDeleted);
		}
		if(petKeys != null) {
			for(java.lang.Long o : petKeys) {
				document.addField("petKeys_indexedstored_longs", o);
			}
		}
		if(enrollmentKeys != null) {
			for(java.lang.Long o : enrollmentKeys) {
				document.addField("enrollmentKeys_indexedstored_longs", o);
			}
		}
		super.indexBaseModel(document);

	}

	public static String varIndexedSiteUser(String entityVar) {
		switch(entityVar) {
			case "userKeys":
				return "userKeys_indexedstored_longs";
			case "userId":
				return "userId_indexedstored_string";
			case "userName":
				return "userName_indexedstored_string";
			case "userEmail":
				return "userEmail_indexedstored_string";
			case "userFirstName":
				return "userFirstName_indexedstored_string";
			case "userLastName":
				return "userLastName_indexedstored_string";
			case "userFullName":
				return "userFullName_indexedstored_string";
			case "userReceiveEmails":
				return "userReceiveEmails_indexedstored_boolean";
			case "seeArchived":
				return "seeArchived_indexedstored_boolean";
			case "seeDeleted":
				return "seeDeleted_indexedstored_boolean";
			case "petKeys":
				return "petKeys_indexedstored_longs";
			case "enrollmentKeys":
				return "enrollmentKeys_indexedstored_longs";
			default:
				return BaseModel.varIndexedBaseModel(entityVar);
		}
	}

	public static String varSearchSiteUser(String entityVar) {
		switch(entityVar) {
			default:
				return BaseModel.varSearchBaseModel(entityVar);
		}
	}

	public static String varSuggestedSiteUser(String entityVar) {
		switch(entityVar) {
			default:
				return BaseModel.varSuggestedBaseModel(entityVar);
		}
	}

	/////////////
	// store //
	/////////////

	@Override public void storeForClass(SolrDocument solrDocument) {
		storeSiteUser(solrDocument);
	}
	public void storeSiteUser(SolrDocument solrDocument) {
		SiteUser oSiteUser = (SiteUser)this;

		Optional.ofNullable((List<?>)solrDocument.get("userKeys_indexedstored_longs")).orElse(Arrays.asList()).stream().filter(v -> v != null).forEach(v -> {
			oSiteUser.addUserKeys(v.toString());
		});
		oSiteUser.setUserId(Optional.ofNullable(solrDocument.get("userId_indexedstored_string")).map(v -> v.toString()).orElse(null));
		oSiteUser.setUserName(Optional.ofNullable(solrDocument.get("userName_indexedstored_string")).map(v -> v.toString()).orElse(null));
		oSiteUser.setUserEmail(Optional.ofNullable(solrDocument.get("userEmail_indexedstored_string")).map(v -> v.toString()).orElse(null));
		oSiteUser.setUserFirstName(Optional.ofNullable(solrDocument.get("userFirstName_indexedstored_string")).map(v -> v.toString()).orElse(null));
		oSiteUser.setUserLastName(Optional.ofNullable(solrDocument.get("userLastName_indexedstored_string")).map(v -> v.toString()).orElse(null));
		oSiteUser.setUserFullName(Optional.ofNullable(solrDocument.get("userFullName_indexedstored_string")).map(v -> v.toString()).orElse(null));
		oSiteUser.setUserReceiveEmails(Optional.ofNullable(solrDocument.get("userReceiveEmails_indexedstored_boolean")).map(v -> v.toString()).orElse(null));
		oSiteUser.setSeeArchived(Optional.ofNullable(solrDocument.get("seeArchived_indexedstored_boolean")).map(v -> v.toString()).orElse(null));
		oSiteUser.setSeeDeleted(Optional.ofNullable(solrDocument.get("seeDeleted_indexedstored_boolean")).map(v -> v.toString()).orElse(null));
		Optional.ofNullable((List<?>)solrDocument.get("petKeys_indexedstored_longs")).orElse(Arrays.asList()).stream().filter(v -> v != null).forEach(v -> {
			oSiteUser.addPetKeys(v.toString());
		});
		Optional.ofNullable((List<?>)solrDocument.get("enrollmentKeys_indexedstored_longs")).orElse(Arrays.asList()).stream().filter(v -> v != null).forEach(v -> {
			oSiteUser.addEnrollmentKeys(v.toString());
		});

		super.storeBaseModel(solrDocument);
	}

	//////////////////
	// apiRequest //
	//////////////////

	public void apiRequestSiteUser() {
		ApiRequest apiRequest = Optional.ofNullable(siteRequest_).map(SiteRequestEnUS::getApiRequest_).orElse(null);
		Object o = Optional.ofNullable(apiRequest).map(ApiRequest::getOriginal).orElse(null);
		if(o != null && o instanceof SiteUser) {
			SiteUser original = (SiteUser)o;
			if(!Objects.equals(userKeys, original.getUserKeys()))
				apiRequest.addVars("userKeys");
			if(!Objects.equals(userId, original.getUserId()))
				apiRequest.addVars("userId");
			if(!Objects.equals(userName, original.getUserName()))
				apiRequest.addVars("userName");
			if(!Objects.equals(userEmail, original.getUserEmail()))
				apiRequest.addVars("userEmail");
			if(!Objects.equals(userFirstName, original.getUserFirstName()))
				apiRequest.addVars("userFirstName");
			if(!Objects.equals(userLastName, original.getUserLastName()))
				apiRequest.addVars("userLastName");
			if(!Objects.equals(userFullName, original.getUserFullName()))
				apiRequest.addVars("userFullName");
			if(!Objects.equals(userReceiveEmails, original.getUserReceiveEmails()))
				apiRequest.addVars("userReceiveEmails");
			if(!Objects.equals(seeArchived, original.getSeeArchived()))
				apiRequest.addVars("seeArchived");
			if(!Objects.equals(seeDeleted, original.getSeeDeleted()))
				apiRequest.addVars("seeDeleted");
			if(!Objects.equals(petKeys, original.getPetKeys()))
				apiRequest.addVars("petKeys");
			if(!Objects.equals(enrollmentKeys, original.getEnrollmentKeys()))
				apiRequest.addVars("enrollmentKeys");
			super.apiRequestBaseModel();
		}
	}

	//////////////
	// toString //
	//////////////

	@Override public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString() + "\n");
		sb.append("SiteUser { ");
		sb.append( "userKeys: " ).append(userKeys);
		sb.append( ", userId: \"" ).append(userId).append( "\"" );
		sb.append( ", userName: \"" ).append(userName).append( "\"" );
		sb.append( ", userEmail: \"" ).append(userEmail).append( "\"" );
		sb.append( ", userFirstName: \"" ).append(userFirstName).append( "\"" );
		sb.append( ", userLastName: \"" ).append(userLastName).append( "\"" );
		sb.append( ", userFullName: \"" ).append(userFullName).append( "\"" );
		sb.append( ", userReceiveEmails: " ).append(userReceiveEmails);
		sb.append( ", seeArchived: " ).append(seeArchived);
		sb.append( ", seeDeleted: " ).append(seeDeleted);
		sb.append( ", petKeys: " ).append(petKeys);
		sb.append( ", enrollmentKeys: " ).append(enrollmentKeys);
		sb.append(" }");
		return sb.toString();
	}

	public static final String VAR_userKeys = "userKeys";
	public static final String VAR_userId = "userId";
	public static final String VAR_userName = "userName";
	public static final String VAR_userEmail = "userEmail";
	public static final String VAR_userFirstName = "userFirstName";
	public static final String VAR_userLastName = "userLastName";
	public static final String VAR_userFullName = "userFullName";
	public static final String VAR_userReceiveEmails = "userReceiveEmails";
	public static final String VAR_seeArchived = "seeArchived";
	public static final String VAR_seeDeleted = "seeDeleted";
	public static final String VAR_petKeys = "petKeys";
	public static final String VAR_enrollmentKeys = "enrollmentKeys";
}
