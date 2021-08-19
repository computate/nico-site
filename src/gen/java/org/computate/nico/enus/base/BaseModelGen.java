package org.computate.nico.enus.base;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Arrays;
import java.util.Date;
import java.time.ZonedDateTime;
import org.slf4j.LoggerFactory;
import org.apache.commons.lang3.StringUtils;
import org.computate.nico.enus.writer.AllWriter;
import java.lang.Long;
import java.util.Locale;
import java.util.Map;
import java.time.ZoneOffset;
import org.computate.nico.enus.base.BaseModel;
import java.math.RoundingMode;
import java.math.MathContext;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.Instant;
import io.vertx.core.Future;
import java.time.ZoneId;
import java.util.Objects;
import java.util.List;
import java.time.OffsetDateTime;
import org.apache.solr.client.solrj.SolrQuery;
import java.util.Optional;
import org.apache.solr.client.solrj.util.ClientUtils;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.apache.solr.common.SolrInputDocument;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.computate.nico.enus.java.ZonedDateTimeSerializer;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import java.time.LocalDateTime;
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
import java.time.temporal.ChronoUnit;
import java.time.format.DateTimeFormatter;
import org.apache.commons.lang3.math.NumberUtils;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.lang.Object;
import org.computate.nico.enus.config.ConfigKeys;

/**	
 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstClasse_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.nico.enus.base.BaseModel&fq=classeEtendGen_indexed_boolean:true">Find the class  in Solr. </a>
 * <br/>
 **/
public abstract class BaseModelGen<DEV> extends Object {
	protected static final Logger LOG = LoggerFactory.getLogger(BaseModel.class);

	//////////////////
	// siteRequest_ //
	//////////////////

	/**	 The entity siteRequest_
	 *	 is defined as null before being initialized. 
	 */
	@JsonIgnore
	@JsonInclude(Include.NON_NULL)
	protected SiteRequestEnUS siteRequest_;
	@JsonIgnore
	public Wrap<SiteRequestEnUS> siteRequest_Wrap = new Wrap<SiteRequestEnUS>().var("siteRequest_").o(siteRequest_);

	/**	<br/> The entity siteRequest_
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.nico.enus.base.BaseModel&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:siteRequest_">Find the entity siteRequest_ in Solr</a>
	 * <br/>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _siteRequest_(Wrap<SiteRequestEnUS> w);

	public SiteRequestEnUS getSiteRequest_() {
		return siteRequest_;
	}

	public void setSiteRequest_(SiteRequestEnUS siteRequest_) {
		this.siteRequest_ = siteRequest_;
		this.siteRequest_Wrap.alreadyInitialized = true;
	}
	public static SiteRequestEnUS staticSetSiteRequest_(SiteRequestEnUS siteRequest_, String o) {
		return null;
	}
	protected BaseModel siteRequest_Init() {
		if(!siteRequest_Wrap.alreadyInitialized) {
			_siteRequest_(siteRequest_Wrap);
			if(siteRequest_ == null)
				setSiteRequest_(siteRequest_Wrap.o);
			siteRequest_Wrap.o(null);
		}
		siteRequest_Wrap.alreadyInitialized(true);
		return (BaseModel)this;
	}

	////////
	// pk //
	////////

	/**	 The entity pk
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected Long pk;
	@JsonIgnore
	public Wrap<Long> pkWrap = new Wrap<Long>().var("pk").o(pk);

	/**	<br/> The entity pk
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.nico.enus.base.BaseModel&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:pk">Find the entity pk in Solr</a>
	 * <br/>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _pk(Wrap<Long> w);

	public Long getPk() {
		return pk;
	}

	public void setPk(Long pk) {
		this.pk = pk;
		this.pkWrap.alreadyInitialized = true;
	}
	@JsonIgnore
	public void setPk(String o) {
		this.pk = BaseModel.staticSetPk(siteRequest_, o);
		this.pkWrap.alreadyInitialized = true;
	}
	public static Long staticSetPk(SiteRequestEnUS siteRequest_, String o) {
		if(NumberUtils.isParsable(o))
			return Long.parseLong(o);
		return null;
	}
	protected BaseModel pkInit() {
		if(!pkWrap.alreadyInitialized) {
			_pk(pkWrap);
			if(pk == null)
				setPk(pkWrap.o);
			pkWrap.o(null);
		}
		pkWrap.alreadyInitialized(true);
		return (BaseModel)this;
	}

	public static Long staticSolrPk(SiteRequestEnUS siteRequest_, Long o) {
		return o;
	}

	public static String staticSolrStrPk(SiteRequestEnUS siteRequest_, Long o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqPk(SiteRequestEnUS siteRequest_, String o) {
		return BaseModel.staticSolrStrPk(siteRequest_, BaseModel.staticSolrPk(siteRequest_, BaseModel.staticSetPk(siteRequest_, o)));
	}

	public Long solrPk() {
		return BaseModel.staticSolrPk(siteRequest_, pk);
	}

	public String strPk() {
		return pk == null ? "" : pk.toString();
	}

	public Long sqlPk() {
		return pk;
	}

	public String jsonPk() {
		return pk == null ? "" : pk.toString();
	}

	///////////////
	// inheritPk //
	///////////////

	/**	 The entity inheritPk
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String inheritPk;
	@JsonIgnore
	public Wrap<String> inheritPkWrap = new Wrap<String>().var("inheritPk").o(inheritPk);

	/**	<br/> The entity inheritPk
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.nico.enus.base.BaseModel&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:inheritPk">Find the entity inheritPk in Solr</a>
	 * <br/>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _inheritPk(Wrap<String> w);

	public String getInheritPk() {
		return inheritPk;
	}
	public void setInheritPk(String o) {
		this.inheritPk = BaseModel.staticSetInheritPk(siteRequest_, o);
		this.inheritPkWrap.alreadyInitialized = true;
	}
	public static String staticSetInheritPk(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	protected BaseModel inheritPkInit() {
		if(!inheritPkWrap.alreadyInitialized) {
			_inheritPk(inheritPkWrap);
			if(inheritPk == null)
				setInheritPk(inheritPkWrap.o);
			inheritPkWrap.o(null);
		}
		inheritPkWrap.alreadyInitialized(true);
		return (BaseModel)this;
	}

	public static String staticSolrInheritPk(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSolrStrInheritPk(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqInheritPk(SiteRequestEnUS siteRequest_, String o) {
		return BaseModel.staticSolrStrInheritPk(siteRequest_, BaseModel.staticSolrInheritPk(siteRequest_, BaseModel.staticSetInheritPk(siteRequest_, o)));
	}

	public String solrInheritPk() {
		return BaseModel.staticSolrInheritPk(siteRequest_, inheritPk);
	}

	public String strInheritPk() {
		return inheritPk == null ? "" : inheritPk;
	}

	public String sqlInheritPk() {
		return inheritPk;
	}

	public String jsonInheritPk() {
		return inheritPk == null ? "" : inheritPk;
	}

	////////
	// id //
	////////

	/**	 The entity id
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String id;
	@JsonIgnore
	public Wrap<String> idWrap = new Wrap<String>().var("id").o(id);

	/**	<br/> The entity id
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.nico.enus.base.BaseModel&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:id">Find the entity id in Solr</a>
	 * <br/>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _id(Wrap<String> w);

	public String getId() {
		return id;
	}
	public void setId(String o) {
		this.id = BaseModel.staticSetId(siteRequest_, o);
		this.idWrap.alreadyInitialized = true;
	}
	public static String staticSetId(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	protected BaseModel idInit() {
		if(!idWrap.alreadyInitialized) {
			_id(idWrap);
			if(id == null)
				setId(idWrap.o);
			idWrap.o(null);
		}
		idWrap.alreadyInitialized(true);
		return (BaseModel)this;
	}

	public static String staticSolrId(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSolrStrId(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqId(SiteRequestEnUS siteRequest_, String o) {
		return BaseModel.staticSolrStrId(siteRequest_, BaseModel.staticSolrId(siteRequest_, BaseModel.staticSetId(siteRequest_, o)));
	}

	public String solrId() {
		return BaseModel.staticSolrId(siteRequest_, id);
	}

	public String strId() {
		return id == null ? "" : id;
	}

	public String sqlId() {
		return id;
	}

	public String jsonId() {
		return id == null ? "" : id;
	}

	/////////////
	// created //
	/////////////

	/**	 The entity created
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonDeserialize(using = ZonedDateTimeDeserializer.class)
	@JsonSerialize(using = ZonedDateTimeSerializer.class)
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ss.SSSV'['VV']'")
	@JsonInclude(Include.NON_NULL)
	protected ZonedDateTime created;
	@JsonIgnore
	public Wrap<ZonedDateTime> createdWrap = new Wrap<ZonedDateTime>().var("created").o(created);

	/**	<br/> The entity created
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.nico.enus.base.BaseModel&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:created">Find the entity created in Solr</a>
	 * <br/>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _created(Wrap<ZonedDateTime> w);

	public ZonedDateTime getCreated() {
		return created;
	}

	public void setCreated(ZonedDateTime created) {
		this.created = created;
		this.createdWrap.alreadyInitialized = true;
	}
	@JsonIgnore
	public void setCreated(Instant o) {
		this.created = o == null ? null : ZonedDateTime.from(o).truncatedTo(ChronoUnit.MILLIS);
		this.createdWrap.alreadyInitialized = true;
	}
	/** Example: 2011-12-03T10:15:30+01:00 **/
	@JsonIgnore
	public void setCreated(String o) {
		this.created = BaseModel.staticSetCreated(siteRequest_, o);
		this.createdWrap.alreadyInitialized = true;
	}
	public static ZonedDateTime staticSetCreated(SiteRequestEnUS siteRequest_, String o) {
		if(StringUtils.endsWith(o, "Z"))
			return o == null ? null : Instant.parse(o).atZone(ZoneId.of(siteRequest_.getConfig().getString(ConfigKeys.SITE_ZONE))).truncatedTo(ChronoUnit.MILLIS);
		else
			return o == null ? null : ZonedDateTime.parse(o, DateTimeFormatter.ISO_DATE_TIME).truncatedTo(ChronoUnit.MILLIS);
	}
	@JsonIgnore
	public void setCreated(Date o) {
		this.created = o == null ? null : ZonedDateTime.ofInstant(o.toInstant(), ZoneId.of(siteRequest_.getConfig().getString(ConfigKeys.SITE_ZONE))).truncatedTo(ChronoUnit.MILLIS);
		this.createdWrap.alreadyInitialized = true;
	}
	protected BaseModel createdInit() {
		if(!createdWrap.alreadyInitialized) {
			_created(createdWrap);
			if(created == null)
				setCreated(createdWrap.o);
			createdWrap.o(null);
		}
		createdWrap.alreadyInitialized(true);
		return (BaseModel)this;
	}

	public static Date staticSolrCreated(SiteRequestEnUS siteRequest_, ZonedDateTime o) {
		return o == null ? null : Date.from(o.toInstant());
	}

	public static String staticSolrStrCreated(SiteRequestEnUS siteRequest_, Date o) {
		return "\"" + DateTimeFormatter.ISO_DATE_TIME.format(o.toInstant().atOffset(ZoneOffset.UTC)) + "\"";
	}

	public static String staticSolrFqCreated(SiteRequestEnUS siteRequest_, String o) {
		return BaseModel.staticSolrStrCreated(siteRequest_, BaseModel.staticSolrCreated(siteRequest_, BaseModel.staticSetCreated(siteRequest_, o)));
	}

	public Date solrCreated() {
		return BaseModel.staticSolrCreated(siteRequest_, created);
	}

	public String strCreated() {
		return created == null ? "" : created.format(DateTimeFormatter.ofPattern("EEE d MMM yyyy H:mm:ss a zz", Locale.forLanguageTag("en-US")));
	}

	public OffsetDateTime sqlCreated() {
		return created == null ? null : created.toOffsetDateTime();
	}

	public String jsonCreated() {
		return created == null ? "" : created.format(DateTimeFormatter.ISO_DATE_TIME);
	}

	//////////////
	// modified //
	//////////////

	/**	 The entity modified
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonDeserialize(using = ZonedDateTimeDeserializer.class)
	@JsonSerialize(using = ZonedDateTimeSerializer.class)
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ss.SSSV'['VV']'")
	@JsonInclude(Include.NON_NULL)
	protected ZonedDateTime modified;
	@JsonIgnore
	public Wrap<ZonedDateTime> modifiedWrap = new Wrap<ZonedDateTime>().var("modified").o(modified);

	/**	<br/> The entity modified
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.nico.enus.base.BaseModel&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:modified">Find the entity modified in Solr</a>
	 * <br/>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _modified(Wrap<ZonedDateTime> w);

	public ZonedDateTime getModified() {
		return modified;
	}

	public void setModified(ZonedDateTime modified) {
		this.modified = modified;
		this.modifiedWrap.alreadyInitialized = true;
	}
	@JsonIgnore
	public void setModified(Instant o) {
		this.modified = o == null ? null : ZonedDateTime.from(o).truncatedTo(ChronoUnit.MILLIS);
		this.modifiedWrap.alreadyInitialized = true;
	}
	/** Example: 2011-12-03T10:15:30+01:00 **/
	@JsonIgnore
	public void setModified(String o) {
		this.modified = BaseModel.staticSetModified(siteRequest_, o);
		this.modifiedWrap.alreadyInitialized = true;
	}
	public static ZonedDateTime staticSetModified(SiteRequestEnUS siteRequest_, String o) {
		if(StringUtils.endsWith(o, "Z"))
			return o == null ? null : Instant.parse(o).atZone(ZoneId.of(siteRequest_.getConfig().getString(ConfigKeys.SITE_ZONE))).truncatedTo(ChronoUnit.MILLIS);
		else
			return o == null ? null : ZonedDateTime.parse(o, DateTimeFormatter.ISO_DATE_TIME).truncatedTo(ChronoUnit.MILLIS);
	}
	@JsonIgnore
	public void setModified(Date o) {
		this.modified = o == null ? null : ZonedDateTime.ofInstant(o.toInstant(), ZoneId.of(siteRequest_.getConfig().getString(ConfigKeys.SITE_ZONE))).truncatedTo(ChronoUnit.MILLIS);
		this.modifiedWrap.alreadyInitialized = true;
	}
	protected BaseModel modifiedInit() {
		if(!modifiedWrap.alreadyInitialized) {
			_modified(modifiedWrap);
			if(modified == null)
				setModified(modifiedWrap.o);
			modifiedWrap.o(null);
		}
		modifiedWrap.alreadyInitialized(true);
		return (BaseModel)this;
	}

	public static Date staticSolrModified(SiteRequestEnUS siteRequest_, ZonedDateTime o) {
		return o == null ? null : Date.from(o.toInstant());
	}

	public static String staticSolrStrModified(SiteRequestEnUS siteRequest_, Date o) {
		return "\"" + DateTimeFormatter.ISO_DATE_TIME.format(o.toInstant().atOffset(ZoneOffset.UTC)) + "\"";
	}

	public static String staticSolrFqModified(SiteRequestEnUS siteRequest_, String o) {
		return BaseModel.staticSolrStrModified(siteRequest_, BaseModel.staticSolrModified(siteRequest_, BaseModel.staticSetModified(siteRequest_, o)));
	}

	public Date solrModified() {
		return BaseModel.staticSolrModified(siteRequest_, modified);
	}

	public String strModified() {
		return modified == null ? "" : modified.format(DateTimeFormatter.ofPattern("EEE d MMM yyyy H:mm:ss a zz", Locale.forLanguageTag("en-US")));
	}

	public OffsetDateTime sqlModified() {
		return modified == null ? null : modified.toOffsetDateTime();
	}

	public String jsonModified() {
		return modified == null ? "" : modified.format(DateTimeFormatter.ISO_DATE_TIME);
	}

	//////////////
	// archived //
	//////////////

	/**	 The entity archived
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected Boolean archived;
	@JsonIgnore
	public Wrap<Boolean> archivedWrap = new Wrap<Boolean>().var("archived").o(archived);

	/**	<br/> The entity archived
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.nico.enus.base.BaseModel&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:archived">Find the entity archived in Solr</a>
	 * <br/>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _archived(Wrap<Boolean> w);

	public Boolean getArchived() {
		return archived;
	}

	public void setArchived(Boolean archived) {
		this.archived = archived;
		this.archivedWrap.alreadyInitialized = true;
	}
	@JsonIgnore
	public void setArchived(String o) {
		this.archived = BaseModel.staticSetArchived(siteRequest_, o);
		this.archivedWrap.alreadyInitialized = true;
	}
	public static Boolean staticSetArchived(SiteRequestEnUS siteRequest_, String o) {
		return Boolean.parseBoolean(o);
	}
	protected BaseModel archivedInit() {
		if(!archivedWrap.alreadyInitialized) {
			_archived(archivedWrap);
			if(archived == null)
				setArchived(archivedWrap.o);
			archivedWrap.o(null);
		}
		archivedWrap.alreadyInitialized(true);
		return (BaseModel)this;
	}

	public static Boolean staticSolrArchived(SiteRequestEnUS siteRequest_, Boolean o) {
		return o;
	}

	public static String staticSolrStrArchived(SiteRequestEnUS siteRequest_, Boolean o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqArchived(SiteRequestEnUS siteRequest_, String o) {
		return BaseModel.staticSolrStrArchived(siteRequest_, BaseModel.staticSolrArchived(siteRequest_, BaseModel.staticSetArchived(siteRequest_, o)));
	}

	public Boolean solrArchived() {
		return BaseModel.staticSolrArchived(siteRequest_, archived);
	}

	public String strArchived() {
		return archived == null ? "" : archived.toString();
	}

	public Boolean sqlArchived() {
		return archived;
	}

	public String jsonArchived() {
		return archived == null ? "" : archived.toString();
	}

	/////////////
	// deleted //
	/////////////

	/**	 The entity deleted
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected Boolean deleted;
	@JsonIgnore
	public Wrap<Boolean> deletedWrap = new Wrap<Boolean>().var("deleted").o(deleted);

	/**	<br/> The entity deleted
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.nico.enus.base.BaseModel&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:deleted">Find the entity deleted in Solr</a>
	 * <br/>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _deleted(Wrap<Boolean> w);

	public Boolean getDeleted() {
		return deleted;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
		this.deletedWrap.alreadyInitialized = true;
	}
	@JsonIgnore
	public void setDeleted(String o) {
		this.deleted = BaseModel.staticSetDeleted(siteRequest_, o);
		this.deletedWrap.alreadyInitialized = true;
	}
	public static Boolean staticSetDeleted(SiteRequestEnUS siteRequest_, String o) {
		return Boolean.parseBoolean(o);
	}
	protected BaseModel deletedInit() {
		if(!deletedWrap.alreadyInitialized) {
			_deleted(deletedWrap);
			if(deleted == null)
				setDeleted(deletedWrap.o);
			deletedWrap.o(null);
		}
		deletedWrap.alreadyInitialized(true);
		return (BaseModel)this;
	}

	public static Boolean staticSolrDeleted(SiteRequestEnUS siteRequest_, Boolean o) {
		return o;
	}

	public static String staticSolrStrDeleted(SiteRequestEnUS siteRequest_, Boolean o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqDeleted(SiteRequestEnUS siteRequest_, String o) {
		return BaseModel.staticSolrStrDeleted(siteRequest_, BaseModel.staticSolrDeleted(siteRequest_, BaseModel.staticSetDeleted(siteRequest_, o)));
	}

	public Boolean solrDeleted() {
		return BaseModel.staticSolrDeleted(siteRequest_, deleted);
	}

	public String strDeleted() {
		return deleted == null ? "" : deleted.toString();
	}

	public Boolean sqlDeleted() {
		return deleted;
	}

	public String jsonDeleted() {
		return deleted == null ? "" : deleted.toString();
	}

	////////////////////////
	// classCanonicalName //
	////////////////////////

	/**	 The entity classCanonicalName
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String classCanonicalName;
	@JsonIgnore
	public Wrap<String> classCanonicalNameWrap = new Wrap<String>().var("classCanonicalName").o(classCanonicalName);

	/**	<br/> The entity classCanonicalName
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.nico.enus.base.BaseModel&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:classCanonicalName">Find the entity classCanonicalName in Solr</a>
	 * <br/>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _classCanonicalName(Wrap<String> w);

	public String getClassCanonicalName() {
		return classCanonicalName;
	}
	public void setClassCanonicalName(String o) {
		this.classCanonicalName = BaseModel.staticSetClassCanonicalName(siteRequest_, o);
		this.classCanonicalNameWrap.alreadyInitialized = true;
	}
	public static String staticSetClassCanonicalName(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	protected BaseModel classCanonicalNameInit() {
		if(!classCanonicalNameWrap.alreadyInitialized) {
			_classCanonicalName(classCanonicalNameWrap);
			if(classCanonicalName == null)
				setClassCanonicalName(classCanonicalNameWrap.o);
			classCanonicalNameWrap.o(null);
		}
		classCanonicalNameWrap.alreadyInitialized(true);
		return (BaseModel)this;
	}

	public static String staticSolrClassCanonicalName(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSolrStrClassCanonicalName(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqClassCanonicalName(SiteRequestEnUS siteRequest_, String o) {
		return BaseModel.staticSolrStrClassCanonicalName(siteRequest_, BaseModel.staticSolrClassCanonicalName(siteRequest_, BaseModel.staticSetClassCanonicalName(siteRequest_, o)));
	}

	public String solrClassCanonicalName() {
		return BaseModel.staticSolrClassCanonicalName(siteRequest_, classCanonicalName);
	}

	public String strClassCanonicalName() {
		return classCanonicalName == null ? "" : classCanonicalName;
	}

	public String sqlClassCanonicalName() {
		return classCanonicalName;
	}

	public String jsonClassCanonicalName() {
		return classCanonicalName == null ? "" : classCanonicalName;
	}

	/////////////////////
	// classSimpleName //
	/////////////////////

	/**	 The entity classSimpleName
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String classSimpleName;
	@JsonIgnore
	public Wrap<String> classSimpleNameWrap = new Wrap<String>().var("classSimpleName").o(classSimpleName);

	/**	<br/> The entity classSimpleName
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.nico.enus.base.BaseModel&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:classSimpleName">Find the entity classSimpleName in Solr</a>
	 * <br/>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _classSimpleName(Wrap<String> w);

	public String getClassSimpleName() {
		return classSimpleName;
	}
	public void setClassSimpleName(String o) {
		this.classSimpleName = BaseModel.staticSetClassSimpleName(siteRequest_, o);
		this.classSimpleNameWrap.alreadyInitialized = true;
	}
	public static String staticSetClassSimpleName(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	protected BaseModel classSimpleNameInit() {
		if(!classSimpleNameWrap.alreadyInitialized) {
			_classSimpleName(classSimpleNameWrap);
			if(classSimpleName == null)
				setClassSimpleName(classSimpleNameWrap.o);
			classSimpleNameWrap.o(null);
		}
		classSimpleNameWrap.alreadyInitialized(true);
		return (BaseModel)this;
	}

	public static String staticSolrClassSimpleName(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSolrStrClassSimpleName(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqClassSimpleName(SiteRequestEnUS siteRequest_, String o) {
		return BaseModel.staticSolrStrClassSimpleName(siteRequest_, BaseModel.staticSolrClassSimpleName(siteRequest_, BaseModel.staticSetClassSimpleName(siteRequest_, o)));
	}

	public String solrClassSimpleName() {
		return BaseModel.staticSolrClassSimpleName(siteRequest_, classSimpleName);
	}

	public String strClassSimpleName() {
		return classSimpleName == null ? "" : classSimpleName;
	}

	public String sqlClassSimpleName() {
		return classSimpleName;
	}

	public String jsonClassSimpleName() {
		return classSimpleName == null ? "" : classSimpleName;
	}

	/////////////////////////
	// classCanonicalNames //
	/////////////////////////

	/**	 The entity classCanonicalNames
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut List<String>(). 
	 */
	@JsonProperty
	@JsonFormat(shape = JsonFormat.Shape.ARRAY)
	@JsonInclude(Include.NON_NULL)
	protected List<String> classCanonicalNames = new ArrayList<String>();
	@JsonIgnore
	public Wrap<List<String>> classCanonicalNamesWrap = new Wrap<List<String>>().var("classCanonicalNames").o(classCanonicalNames);

	/**	<br/> The entity classCanonicalNames
	 *  It is constructed before being initialized with the constructor by default List<String>(). 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.nico.enus.base.BaseModel&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:classCanonicalNames">Find the entity classCanonicalNames in Solr</a>
	 * <br/>
	 * @param classCanonicalNames is the entity already constructed. 
	 **/
	protected abstract void _classCanonicalNames(List<String> l);

	public List<String> getClassCanonicalNames() {
		return classCanonicalNames;
	}

	public void setClassCanonicalNames(List<String> classCanonicalNames) {
		this.classCanonicalNames = classCanonicalNames;
		this.classCanonicalNamesWrap.alreadyInitialized = true;
	}
	public static String staticSetClassCanonicalNames(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	public BaseModel addClassCanonicalNames(String...objets) {
		for(String o : objets) {
			addClassCanonicalNames(o);
		}
		return (BaseModel)this;
	}
	public BaseModel addClassCanonicalNames(String o) {
		if(o != null && !classCanonicalNames.contains(o))
			this.classCanonicalNames.add(o);
		return (BaseModel)this;
	}
	@JsonIgnore
	public void setClassCanonicalNames(JsonArray objets) {
		classCanonicalNames.clear();
		for(int i = 0; i < objets.size(); i++) {
			String o = objets.getString(i);
			addClassCanonicalNames(o);
		}
	}
	protected BaseModel classCanonicalNamesInit() {
		if(!classCanonicalNamesWrap.alreadyInitialized) {
			_classCanonicalNames(classCanonicalNames);
		}
		classCanonicalNamesWrap.alreadyInitialized(true);
		return (BaseModel)this;
	}

	public static String staticSolrClassCanonicalNames(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSolrStrClassCanonicalNames(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqClassCanonicalNames(SiteRequestEnUS siteRequest_, String o) {
		return BaseModel.staticSolrStrClassCanonicalNames(siteRequest_, BaseModel.staticSolrClassCanonicalNames(siteRequest_, BaseModel.staticSetClassCanonicalNames(siteRequest_, o)));
	}

	public List<String> solrClassCanonicalNames() {
		List<String> l = new ArrayList<String>();
		for(String o : classCanonicalNames) {
			l.add(BaseModel.staticSolrClassCanonicalNames(siteRequest_, o));
		}
		return l;
	}

	public String strClassCanonicalNames() {
		return classCanonicalNames == null ? "" : classCanonicalNames.toString();
	}

	public List<String> sqlClassCanonicalNames() {
		return classCanonicalNames;
	}

	public String jsonClassCanonicalNames() {
		return classCanonicalNames == null ? "" : classCanonicalNames.toString();
	}

	///////////////
	// sessionId //
	///////////////

	/**	 The entity sessionId
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String sessionId;
	@JsonIgnore
	public Wrap<String> sessionIdWrap = new Wrap<String>().var("sessionId").o(sessionId);

	/**	<br/> The entity sessionId
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.nico.enus.base.BaseModel&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:sessionId">Find the entity sessionId in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _sessionId(Wrap<String> c);

	public String getSessionId() {
		return sessionId;
	}
	public void setSessionId(String o) {
		this.sessionId = BaseModel.staticSetSessionId(siteRequest_, o);
		this.sessionIdWrap.alreadyInitialized = true;
	}
	public static String staticSetSessionId(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	protected BaseModel sessionIdInit() {
		if(!sessionIdWrap.alreadyInitialized) {
			_sessionId(sessionIdWrap);
			if(sessionId == null)
				setSessionId(sessionIdWrap.o);
			sessionIdWrap.o(null);
		}
		sessionIdWrap.alreadyInitialized(true);
		return (BaseModel)this;
	}

	public static String staticSolrSessionId(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSolrStrSessionId(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqSessionId(SiteRequestEnUS siteRequest_, String o) {
		return BaseModel.staticSolrStrSessionId(siteRequest_, BaseModel.staticSolrSessionId(siteRequest_, BaseModel.staticSetSessionId(siteRequest_, o)));
	}

	public String solrSessionId() {
		return BaseModel.staticSolrSessionId(siteRequest_, sessionId);
	}

	public String strSessionId() {
		return sessionId == null ? "" : sessionId;
	}

	public String sqlSessionId() {
		return sessionId;
	}

	public String jsonSessionId() {
		return sessionId == null ? "" : sessionId;
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
	@JsonIgnore
	public Wrap<String> userIdWrap = new Wrap<String>().var("userId").o(userId);

	/**	<br/> The entity userId
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.nico.enus.base.BaseModel&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:userId">Find the entity userId in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _userId(Wrap<String> c);

	public String getUserId() {
		return userId;
	}
	public void setUserId(String o) {
		this.userId = BaseModel.staticSetUserId(siteRequest_, o);
		this.userIdWrap.alreadyInitialized = true;
	}
	public static String staticSetUserId(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	protected BaseModel userIdInit() {
		if(!userIdWrap.alreadyInitialized) {
			_userId(userIdWrap);
			if(userId == null)
				setUserId(userIdWrap.o);
			userIdWrap.o(null);
		}
		userIdWrap.alreadyInitialized(true);
		return (BaseModel)this;
	}

	public static String staticSolrUserId(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSolrStrUserId(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqUserId(SiteRequestEnUS siteRequest_, String o) {
		return BaseModel.staticSolrStrUserId(siteRequest_, BaseModel.staticSolrUserId(siteRequest_, BaseModel.staticSetUserId(siteRequest_, o)));
	}

	public String solrUserId() {
		return BaseModel.staticSolrUserId(siteRequest_, userId);
	}

	public String strUserId() {
		return userId == null ? "" : userId;
	}

	public String sqlUserId() {
		return userId;
	}

	public String jsonUserId() {
		return userId == null ? "" : userId;
	}

	/////////////
	// userKey //
	/////////////

	/**	 The entity userKey
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonSerialize(using = ToStringSerializer.class)
	@JsonInclude(Include.NON_NULL)
	protected Long userKey;
	@JsonIgnore
	public Wrap<Long> userKeyWrap = new Wrap<Long>().var("userKey").o(userKey);

	/**	<br/> The entity userKey
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.nico.enus.base.BaseModel&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:userKey">Find the entity userKey in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _userKey(Wrap<Long> c);

	public Long getUserKey() {
		return userKey;
	}

	public void setUserKey(Long userKey) {
		this.userKey = userKey;
		this.userKeyWrap.alreadyInitialized = true;
	}
	@JsonIgnore
	public void setUserKey(String o) {
		this.userKey = BaseModel.staticSetUserKey(siteRequest_, o);
		this.userKeyWrap.alreadyInitialized = true;
	}
	public static Long staticSetUserKey(SiteRequestEnUS siteRequest_, String o) {
		if(NumberUtils.isParsable(o))
			return Long.parseLong(o);
		return null;
	}
	protected BaseModel userKeyInit() {
		if(!userKeyWrap.alreadyInitialized) {
			_userKey(userKeyWrap);
			if(userKey == null)
				setUserKey(userKeyWrap.o);
			userKeyWrap.o(null);
		}
		userKeyWrap.alreadyInitialized(true);
		return (BaseModel)this;
	}

	public static Long staticSolrUserKey(SiteRequestEnUS siteRequest_, Long o) {
		return o;
	}

	public static String staticSolrStrUserKey(SiteRequestEnUS siteRequest_, Long o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqUserKey(SiteRequestEnUS siteRequest_, String o) {
		return BaseModel.staticSolrStrUserKey(siteRequest_, BaseModel.staticSolrUserKey(siteRequest_, BaseModel.staticSetUserKey(siteRequest_, o)));
	}

	public Long solrUserKey() {
		return BaseModel.staticSolrUserKey(siteRequest_, userKey);
	}

	public String strUserKey() {
		return userKey == null ? "" : userKey.toString();
	}

	public Long sqlUserKey() {
		return userKey;
	}

	public String jsonUserKey() {
		return userKey == null ? "" : userKey.toString();
	}

	///////////
	// saves //
	///////////

	/**	 The entity saves
	 *	Il est construit avant d'être initialisé avec le constructeur par défaut List<String>(). 
	 */
	@JsonProperty
	@JsonFormat(shape = JsonFormat.Shape.ARRAY)
	@JsonInclude(Include.NON_NULL)
	protected List<String> saves = new ArrayList<String>();
	@JsonIgnore
	public Wrap<List<String>> savesWrap = new Wrap<List<String>>().var("saves").o(saves);

	/**	<br/> The entity saves
	 *  It is constructed before being initialized with the constructor by default List<String>(). 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.nico.enus.base.BaseModel&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:saves">Find the entity saves in Solr</a>
	 * <br/>
	 * @param saves is the entity already constructed. 
	 **/
	protected abstract void _saves(List<String> l);

	public List<String> getSaves() {
		return saves;
	}

	public void setSaves(List<String> saves) {
		this.saves = saves;
		this.savesWrap.alreadyInitialized = true;
	}
	public static String staticSetSaves(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	public BaseModel addSaves(String...objets) {
		for(String o : objets) {
			addSaves(o);
		}
		return (BaseModel)this;
	}
	public BaseModel addSaves(String o) {
		if(o != null && !saves.contains(o))
			this.saves.add(o);
		return (BaseModel)this;
	}
	@JsonIgnore
	public void setSaves(JsonArray objets) {
		saves.clear();
		for(int i = 0; i < objets.size(); i++) {
			String o = objets.getString(i);
			addSaves(o);
		}
	}
	protected BaseModel savesInit() {
		if(!savesWrap.alreadyInitialized) {
			_saves(saves);
		}
		savesWrap.alreadyInitialized(true);
		return (BaseModel)this;
	}

	public static String staticSolrSaves(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSolrStrSaves(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqSaves(SiteRequestEnUS siteRequest_, String o) {
		return BaseModel.staticSolrStrSaves(siteRequest_, BaseModel.staticSolrSaves(siteRequest_, BaseModel.staticSetSaves(siteRequest_, o)));
	}

	public List<String> solrSaves() {
		List<String> l = new ArrayList<String>();
		for(String o : saves) {
			l.add(BaseModel.staticSolrSaves(siteRequest_, o));
		}
		return l;
	}

	public String strSaves() {
		return saves == null ? "" : saves.toString();
	}

	public List<String> sqlSaves() {
		return saves;
	}

	public String jsonSaves() {
		return saves == null ? "" : saves.toString();
	}

	/////////////////
	// objectTitle //
	/////////////////

	/**	 The entity objectTitle
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String objectTitle;
	@JsonIgnore
	public Wrap<String> objectTitleWrap = new Wrap<String>().var("objectTitle").o(objectTitle);

	/**	<br/> The entity objectTitle
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.nico.enus.base.BaseModel&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:objectTitle">Find the entity objectTitle in Solr</a>
	 * <br/>
	 * @param w is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _objectTitle(Wrap<String> w);

	public String getObjectTitle() {
		return objectTitle;
	}
	public void setObjectTitle(String o) {
		this.objectTitle = BaseModel.staticSetObjectTitle(siteRequest_, o);
		this.objectTitleWrap.alreadyInitialized = true;
	}
	public static String staticSetObjectTitle(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	protected BaseModel objectTitleInit() {
		if(!objectTitleWrap.alreadyInitialized) {
			_objectTitle(objectTitleWrap);
			if(objectTitle == null)
				setObjectTitle(objectTitleWrap.o);
			objectTitleWrap.o(null);
		}
		objectTitleWrap.alreadyInitialized(true);
		return (BaseModel)this;
	}

	public static String staticSolrObjectTitle(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSolrStrObjectTitle(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqObjectTitle(SiteRequestEnUS siteRequest_, String o) {
		return BaseModel.staticSolrStrObjectTitle(siteRequest_, BaseModel.staticSolrObjectTitle(siteRequest_, BaseModel.staticSetObjectTitle(siteRequest_, o)));
	}

	public String solrObjectTitle() {
		return BaseModel.staticSolrObjectTitle(siteRequest_, objectTitle);
	}

	public String strObjectTitle() {
		return objectTitle == null ? "" : objectTitle;
	}

	public String sqlObjectTitle() {
		return objectTitle;
	}

	public String jsonObjectTitle() {
		return objectTitle == null ? "" : objectTitle;
	}

	//////////////
	// objectId //
	//////////////

	/**	 The entity objectId
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String objectId;
	@JsonIgnore
	public Wrap<String> objectIdWrap = new Wrap<String>().var("objectId").o(objectId);

	/**	<br/> The entity objectId
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.nico.enus.base.BaseModel&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:objectId">Find the entity objectId in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _objectId(Wrap<String> c);

	public String getObjectId() {
		return objectId;
	}
	public void setObjectId(String o) {
		this.objectId = BaseModel.staticSetObjectId(siteRequest_, o);
		this.objectIdWrap.alreadyInitialized = true;
	}
	public static String staticSetObjectId(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	protected BaseModel objectIdInit() {
		if(!objectIdWrap.alreadyInitialized) {
			_objectId(objectIdWrap);
			if(objectId == null)
				setObjectId(objectIdWrap.o);
			objectIdWrap.o(null);
		}
		objectIdWrap.alreadyInitialized(true);
		return (BaseModel)this;
	}

	public static String staticSolrObjectId(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSolrStrObjectId(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqObjectId(SiteRequestEnUS siteRequest_, String o) {
		return BaseModel.staticSolrStrObjectId(siteRequest_, BaseModel.staticSolrObjectId(siteRequest_, BaseModel.staticSetObjectId(siteRequest_, o)));
	}

	public String solrObjectId() {
		return BaseModel.staticSolrObjectId(siteRequest_, objectId);
	}

	public String strObjectId() {
		return objectId == null ? "" : objectId;
	}

	public String sqlObjectId() {
		return objectId;
	}

	public String jsonObjectId() {
		return objectId == null ? "" : objectId;
	}

	///////////////////
	// objectNameVar //
	///////////////////

	/**	 The entity objectNameVar
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String objectNameVar;
	@JsonIgnore
	public Wrap<String> objectNameVarWrap = new Wrap<String>().var("objectNameVar").o(objectNameVar);

	/**	<br/> The entity objectNameVar
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.nico.enus.base.BaseModel&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:objectNameVar">Find the entity objectNameVar in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _objectNameVar(Wrap<String> c);

	public String getObjectNameVar() {
		return objectNameVar;
	}
	public void setObjectNameVar(String o) {
		this.objectNameVar = BaseModel.staticSetObjectNameVar(siteRequest_, o);
		this.objectNameVarWrap.alreadyInitialized = true;
	}
	public static String staticSetObjectNameVar(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	protected BaseModel objectNameVarInit() {
		if(!objectNameVarWrap.alreadyInitialized) {
			_objectNameVar(objectNameVarWrap);
			if(objectNameVar == null)
				setObjectNameVar(objectNameVarWrap.o);
			objectNameVarWrap.o(null);
		}
		objectNameVarWrap.alreadyInitialized(true);
		return (BaseModel)this;
	}

	public static String staticSolrObjectNameVar(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSolrStrObjectNameVar(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqObjectNameVar(SiteRequestEnUS siteRequest_, String o) {
		return BaseModel.staticSolrStrObjectNameVar(siteRequest_, BaseModel.staticSolrObjectNameVar(siteRequest_, BaseModel.staticSetObjectNameVar(siteRequest_, o)));
	}

	public String solrObjectNameVar() {
		return BaseModel.staticSolrObjectNameVar(siteRequest_, objectNameVar);
	}

	public String strObjectNameVar() {
		return objectNameVar == null ? "" : objectNameVar;
	}

	public String sqlObjectNameVar() {
		return objectNameVar;
	}

	public String jsonObjectNameVar() {
		return objectNameVar == null ? "" : objectNameVar;
	}

	///////////////////
	// objectSuggest //
	///////////////////

	/**	 The entity objectSuggest
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String objectSuggest;
	@JsonIgnore
	public Wrap<String> objectSuggestWrap = new Wrap<String>().var("objectSuggest").o(objectSuggest);

	/**	<br/> The entity objectSuggest
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.nico.enus.base.BaseModel&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:objectSuggest">Find the entity objectSuggest in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _objectSuggest(Wrap<String> c);

	public String getObjectSuggest() {
		return objectSuggest;
	}
	public void setObjectSuggest(String o) {
		this.objectSuggest = BaseModel.staticSetObjectSuggest(siteRequest_, o);
		this.objectSuggestWrap.alreadyInitialized = true;
	}
	public static String staticSetObjectSuggest(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	protected BaseModel objectSuggestInit() {
		if(!objectSuggestWrap.alreadyInitialized) {
			_objectSuggest(objectSuggestWrap);
			if(objectSuggest == null)
				setObjectSuggest(objectSuggestWrap.o);
			objectSuggestWrap.o(null);
		}
		objectSuggestWrap.alreadyInitialized(true);
		return (BaseModel)this;
	}

	public static String staticSolrObjectSuggest(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSolrStrObjectSuggest(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqObjectSuggest(SiteRequestEnUS siteRequest_, String o) {
		return BaseModel.staticSolrStrObjectSuggest(siteRequest_, BaseModel.staticSolrObjectSuggest(siteRequest_, BaseModel.staticSetObjectSuggest(siteRequest_, o)));
	}

	public String solrObjectSuggest() {
		return BaseModel.staticSolrObjectSuggest(siteRequest_, objectSuggest);
	}

	public String strObjectSuggest() {
		return objectSuggest == null ? "" : objectSuggest;
	}

	public String sqlObjectSuggest() {
		return objectSuggest;
	}

	public String jsonObjectSuggest() {
		return objectSuggest == null ? "" : objectSuggest;
	}

	////////////////
	// objectText //
	////////////////

	/**	 The entity objectText
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String objectText;
	@JsonIgnore
	public Wrap<String> objectTextWrap = new Wrap<String>().var("objectText").o(objectText);

	/**	<br/> The entity objectText
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.nico.enus.base.BaseModel&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:objectText">Find the entity objectText in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _objectText(Wrap<String> c);

	public String getObjectText() {
		return objectText;
	}
	public void setObjectText(String o) {
		this.objectText = BaseModel.staticSetObjectText(siteRequest_, o);
		this.objectTextWrap.alreadyInitialized = true;
	}
	public static String staticSetObjectText(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	protected BaseModel objectTextInit() {
		if(!objectTextWrap.alreadyInitialized) {
			_objectText(objectTextWrap);
			if(objectText == null)
				setObjectText(objectTextWrap.o);
			objectTextWrap.o(null);
		}
		objectTextWrap.alreadyInitialized(true);
		return (BaseModel)this;
	}

	public static String staticSolrObjectText(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSolrStrObjectText(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqObjectText(SiteRequestEnUS siteRequest_, String o) {
		return BaseModel.staticSolrStrObjectText(siteRequest_, BaseModel.staticSolrObjectText(siteRequest_, BaseModel.staticSetObjectText(siteRequest_, o)));
	}

	public String solrObjectText() {
		return BaseModel.staticSolrObjectText(siteRequest_, objectText);
	}

	public String strObjectText() {
		return objectText == null ? "" : objectText;
	}

	public String sqlObjectText() {
		return objectText;
	}

	public String jsonObjectText() {
		return objectText == null ? "" : objectText;
	}

	///////////////
	// pageUrlId //
	///////////////

	/**	 The entity pageUrlId
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String pageUrlId;
	@JsonIgnore
	public Wrap<String> pageUrlIdWrap = new Wrap<String>().var("pageUrlId").o(pageUrlId);

	/**	<br/> The entity pageUrlId
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.nico.enus.base.BaseModel&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:pageUrlId">Find the entity pageUrlId in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _pageUrlId(Wrap<String> c);

	public String getPageUrlId() {
		return pageUrlId;
	}
	public void setPageUrlId(String o) {
		this.pageUrlId = BaseModel.staticSetPageUrlId(siteRequest_, o);
		this.pageUrlIdWrap.alreadyInitialized = true;
	}
	public static String staticSetPageUrlId(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	protected BaseModel pageUrlIdInit() {
		if(!pageUrlIdWrap.alreadyInitialized) {
			_pageUrlId(pageUrlIdWrap);
			if(pageUrlId == null)
				setPageUrlId(pageUrlIdWrap.o);
			pageUrlIdWrap.o(null);
		}
		pageUrlIdWrap.alreadyInitialized(true);
		return (BaseModel)this;
	}

	public static String staticSolrPageUrlId(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSolrStrPageUrlId(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqPageUrlId(SiteRequestEnUS siteRequest_, String o) {
		return BaseModel.staticSolrStrPageUrlId(siteRequest_, BaseModel.staticSolrPageUrlId(siteRequest_, BaseModel.staticSetPageUrlId(siteRequest_, o)));
	}

	public String solrPageUrlId() {
		return BaseModel.staticSolrPageUrlId(siteRequest_, pageUrlId);
	}

	public String strPageUrlId() {
		return pageUrlId == null ? "" : pageUrlId;
	}

	public String sqlPageUrlId() {
		return pageUrlId;
	}

	public String jsonPageUrlId() {
		return pageUrlId == null ? "" : pageUrlId;
	}

	///////////////
	// pageUrlPk //
	///////////////

	/**	 The entity pageUrlPk
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String pageUrlPk;
	@JsonIgnore
	public Wrap<String> pageUrlPkWrap = new Wrap<String>().var("pageUrlPk").o(pageUrlPk);

	/**	<br/> The entity pageUrlPk
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.nico.enus.base.BaseModel&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:pageUrlPk">Find the entity pageUrlPk in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _pageUrlPk(Wrap<String> c);

	public String getPageUrlPk() {
		return pageUrlPk;
	}
	public void setPageUrlPk(String o) {
		this.pageUrlPk = BaseModel.staticSetPageUrlPk(siteRequest_, o);
		this.pageUrlPkWrap.alreadyInitialized = true;
	}
	public static String staticSetPageUrlPk(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	protected BaseModel pageUrlPkInit() {
		if(!pageUrlPkWrap.alreadyInitialized) {
			_pageUrlPk(pageUrlPkWrap);
			if(pageUrlPk == null)
				setPageUrlPk(pageUrlPkWrap.o);
			pageUrlPkWrap.o(null);
		}
		pageUrlPkWrap.alreadyInitialized(true);
		return (BaseModel)this;
	}

	public static String staticSolrPageUrlPk(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSolrStrPageUrlPk(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqPageUrlPk(SiteRequestEnUS siteRequest_, String o) {
		return BaseModel.staticSolrStrPageUrlPk(siteRequest_, BaseModel.staticSolrPageUrlPk(siteRequest_, BaseModel.staticSetPageUrlPk(siteRequest_, o)));
	}

	public String solrPageUrlPk() {
		return BaseModel.staticSolrPageUrlPk(siteRequest_, pageUrlPk);
	}

	public String strPageUrlPk() {
		return pageUrlPk == null ? "" : pageUrlPk;
	}

	public String sqlPageUrlPk() {
		return pageUrlPk;
	}

	public String jsonPageUrlPk() {
		return pageUrlPk == null ? "" : pageUrlPk;
	}

	////////////////
	// pageUrlApi //
	////////////////

	/**	 The entity pageUrlApi
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String pageUrlApi;
	@JsonIgnore
	public Wrap<String> pageUrlApiWrap = new Wrap<String>().var("pageUrlApi").o(pageUrlApi);

	/**	<br/> The entity pageUrlApi
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.nico.enus.base.BaseModel&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:pageUrlApi">Find the entity pageUrlApi in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _pageUrlApi(Wrap<String> c);

	public String getPageUrlApi() {
		return pageUrlApi;
	}
	public void setPageUrlApi(String o) {
		this.pageUrlApi = BaseModel.staticSetPageUrlApi(siteRequest_, o);
		this.pageUrlApiWrap.alreadyInitialized = true;
	}
	public static String staticSetPageUrlApi(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	protected BaseModel pageUrlApiInit() {
		if(!pageUrlApiWrap.alreadyInitialized) {
			_pageUrlApi(pageUrlApiWrap);
			if(pageUrlApi == null)
				setPageUrlApi(pageUrlApiWrap.o);
			pageUrlApiWrap.o(null);
		}
		pageUrlApiWrap.alreadyInitialized(true);
		return (BaseModel)this;
	}

	public static String staticSolrPageUrlApi(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSolrStrPageUrlApi(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqPageUrlApi(SiteRequestEnUS siteRequest_, String o) {
		return BaseModel.staticSolrStrPageUrlApi(siteRequest_, BaseModel.staticSolrPageUrlApi(siteRequest_, BaseModel.staticSetPageUrlApi(siteRequest_, o)));
	}

	public String solrPageUrlApi() {
		return BaseModel.staticSolrPageUrlApi(siteRequest_, pageUrlApi);
	}

	public String strPageUrlApi() {
		return pageUrlApi == null ? "" : pageUrlApi;
	}

	public String sqlPageUrlApi() {
		return pageUrlApi;
	}

	public String jsonPageUrlApi() {
		return pageUrlApi == null ? "" : pageUrlApi;
	}

	////////////
	// pageH1 //
	////////////

	/**	 The entity pageH1
	 *	 is defined as null before being initialized. 
	 */
	@JsonProperty
	@JsonInclude(Include.NON_NULL)
	protected String pageH1;
	@JsonIgnore
	public Wrap<String> pageH1Wrap = new Wrap<String>().var("pageH1").o(pageH1);

	/**	<br/> The entity pageH1
	 *  is defined as null before being initialized. 
	 * <br/><a href="http://localhost:8983/solr/computate/select?q=*:*&fq=partEstEntite_indexed_boolean:true&fq=classeNomCanonique_enUS_indexed_string:org.computate.nico.enus.base.BaseModel&fq=classeEtendGen_indexed_boolean:true&fq=entiteVar_enUS_indexed_string:pageH1">Find the entity pageH1 in Solr</a>
	 * <br/>
	 * @param c is for wrapping a value to assign to this entity during initialization. 
	 **/
	protected abstract void _pageH1(Wrap<String> c);

	public String getPageH1() {
		return pageH1;
	}
	public void setPageH1(String o) {
		this.pageH1 = BaseModel.staticSetPageH1(siteRequest_, o);
		this.pageH1Wrap.alreadyInitialized = true;
	}
	public static String staticSetPageH1(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}
	protected BaseModel pageH1Init() {
		if(!pageH1Wrap.alreadyInitialized) {
			_pageH1(pageH1Wrap);
			if(pageH1 == null)
				setPageH1(pageH1Wrap.o);
			pageH1Wrap.o(null);
		}
		pageH1Wrap.alreadyInitialized(true);
		return (BaseModel)this;
	}

	public static String staticSolrPageH1(SiteRequestEnUS siteRequest_, String o) {
		return o;
	}

	public static String staticSolrStrPageH1(SiteRequestEnUS siteRequest_, String o) {
		return o == null ? null : o.toString();
	}

	public static String staticSolrFqPageH1(SiteRequestEnUS siteRequest_, String o) {
		return BaseModel.staticSolrStrPageH1(siteRequest_, BaseModel.staticSolrPageH1(siteRequest_, BaseModel.staticSetPageH1(siteRequest_, o)));
	}

	public String solrPageH1() {
		return BaseModel.staticSolrPageH1(siteRequest_, pageH1);
	}

	public String strPageH1() {
		return pageH1 == null ? "" : pageH1;
	}

	public String sqlPageH1() {
		return pageH1;
	}

	public String jsonPageH1() {
		return pageH1 == null ? "" : pageH1;
	}

	//////////////
	// initDeep //
	//////////////

	protected boolean alreadyInitializedBaseModel = false;

	public Future<Void> promiseDeepBaseModel(SiteRequestEnUS siteRequest_) {
		setSiteRequest_(siteRequest_);
		if(!alreadyInitializedBaseModel) {
			alreadyInitializedBaseModel = true;
			return promiseDeepBaseModel();
		} else {
			return Future.succeededFuture();
		}
	}

	public Future<Void> promiseDeepBaseModel() {
		Promise<Void> promise = Promise.promise();
		Promise<Void> promise2 = Promise.promise();
		promiseBaseModel(promise2);
		promise2.future().onSuccess(a -> {
			promise.complete();
		}).onFailure(ex -> {
			promise.fail(ex);
		});
		return promise.future();
	}

	public Future<Void> promiseBaseModel(Promise<Void> promise) {
		Future.future(a -> a.complete()).compose(a -> {
			Promise<Void> promise2 = Promise.promise();
			try {
				siteRequest_Init();
				pkInit();
				inheritPkInit();
				idInit();
				createdInit();
				modifiedInit();
				archivedInit();
				deletedInit();
				classCanonicalNameInit();
				classSimpleNameInit();
				classCanonicalNamesInit();
				sessionIdInit();
				userIdInit();
				userKeyInit();
				savesInit();
				objectTitleInit();
				objectIdInit();
				objectNameVarInit();
				objectSuggestInit();
				objectTextInit();
				pageUrlIdInit();
				pageUrlPkInit();
				pageUrlApiInit();
				pageH1Init();
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

	public Future<Void> promiseDeepForClass(SiteRequestEnUS siteRequest_) {
		return promiseDeepBaseModel(siteRequest_);
	}

	/////////////////
	// siteRequest //
	/////////////////

	public void siteRequestBaseModel(SiteRequestEnUS siteRequest_) {
	}

	public void siteRequestForClass(SiteRequestEnUS siteRequest_) {
		siteRequestBaseModel(siteRequest_);
	}

	/////////////
	// obtain //
	/////////////

	public Object obtainForClass(String var) {
		String[] vars = StringUtils.split(var, ".");
		Object o = null;
		for(String v : vars) {
			if(o == null)
				o = obtainBaseModel(v);
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
	public Object obtainBaseModel(String var) {
		BaseModel oBaseModel = (BaseModel)this;
		switch(var) {
			case "siteRequest_":
				return oBaseModel.siteRequest_;
			case "pk":
				return oBaseModel.pk;
			case "inheritPk":
				return oBaseModel.inheritPk;
			case "id":
				return oBaseModel.id;
			case "created":
				return oBaseModel.created;
			case "modified":
				return oBaseModel.modified;
			case "archived":
				return oBaseModel.archived;
			case "deleted":
				return oBaseModel.deleted;
			case "classCanonicalName":
				return oBaseModel.classCanonicalName;
			case "classSimpleName":
				return oBaseModel.classSimpleName;
			case "classCanonicalNames":
				return oBaseModel.classCanonicalNames;
			case "sessionId":
				return oBaseModel.sessionId;
			case "userId":
				return oBaseModel.userId;
			case "userKey":
				return oBaseModel.userKey;
			case "saves":
				return oBaseModel.saves;
			case "objectTitle":
				return oBaseModel.objectTitle;
			case "objectId":
				return oBaseModel.objectId;
			case "objectNameVar":
				return oBaseModel.objectNameVar;
			case "objectSuggest":
				return oBaseModel.objectSuggest;
			case "objectText":
				return oBaseModel.objectText;
			case "pageUrlId":
				return oBaseModel.pageUrlId;
			case "pageUrlPk":
				return oBaseModel.pageUrlPk;
			case "pageUrlApi":
				return oBaseModel.pageUrlApi;
			case "pageH1":
				return oBaseModel.pageH1;
			default:
				return null;
		}
	}

	///////////////
	// attribute //
	///////////////

	public boolean attributeForClass(String var, Object val) {
		String[] vars = StringUtils.split(var, ".");
		Object o = null;
		for(String v : vars) {
			if(o == null)
				o = attributeBaseModel(v, val);
			else if(o instanceof BaseModel) {
				BaseModel baseModel = (BaseModel)o;
				o = baseModel.attributeForClass(v, val);
			}
		}
		return o != null;
	}
	public Object attributeBaseModel(String var, Object val) {
		BaseModel oBaseModel = (BaseModel)this;
		switch(var) {
			default:
				return null;
		}
	}

	///////////////
	// staticSet //
	///////////////

	public static Object staticSetForClass(String entityVar, SiteRequestEnUS siteRequest_, String o) {
		return staticSetBaseModel(entityVar,  siteRequest_, o);
	}
	public static Object staticSetBaseModel(String entityVar, SiteRequestEnUS siteRequest_, String o) {
		switch(entityVar) {
		case "pk":
			return BaseModel.staticSetPk(siteRequest_, o);
		case "inheritPk":
			return BaseModel.staticSetInheritPk(siteRequest_, o);
		case "id":
			return BaseModel.staticSetId(siteRequest_, o);
		case "created":
			return BaseModel.staticSetCreated(siteRequest_, o);
		case "modified":
			return BaseModel.staticSetModified(siteRequest_, o);
		case "archived":
			return BaseModel.staticSetArchived(siteRequest_, o);
		case "deleted":
			return BaseModel.staticSetDeleted(siteRequest_, o);
		case "classCanonicalName":
			return BaseModel.staticSetClassCanonicalName(siteRequest_, o);
		case "classSimpleName":
			return BaseModel.staticSetClassSimpleName(siteRequest_, o);
		case "classCanonicalNames":
			return BaseModel.staticSetClassCanonicalNames(siteRequest_, o);
		case "sessionId":
			return BaseModel.staticSetSessionId(siteRequest_, o);
		case "userId":
			return BaseModel.staticSetUserId(siteRequest_, o);
		case "userKey":
			return BaseModel.staticSetUserKey(siteRequest_, o);
		case "saves":
			return BaseModel.staticSetSaves(siteRequest_, o);
		case "objectTitle":
			return BaseModel.staticSetObjectTitle(siteRequest_, o);
		case "objectId":
			return BaseModel.staticSetObjectId(siteRequest_, o);
		case "objectNameVar":
			return BaseModel.staticSetObjectNameVar(siteRequest_, o);
		case "objectSuggest":
			return BaseModel.staticSetObjectSuggest(siteRequest_, o);
		case "objectText":
			return BaseModel.staticSetObjectText(siteRequest_, o);
		case "pageUrlId":
			return BaseModel.staticSetPageUrlId(siteRequest_, o);
		case "pageUrlPk":
			return BaseModel.staticSetPageUrlPk(siteRequest_, o);
		case "pageUrlApi":
			return BaseModel.staticSetPageUrlApi(siteRequest_, o);
		case "pageH1":
			return BaseModel.staticSetPageH1(siteRequest_, o);
			default:
				return null;
		}
	}

	////////////////
	// staticSolr //
	////////////////

	public static Object staticSolrForClass(String entityVar, SiteRequestEnUS siteRequest_, Object o) {
		return staticSolrBaseModel(entityVar,  siteRequest_, o);
	}
	public static Object staticSolrBaseModel(String entityVar, SiteRequestEnUS siteRequest_, Object o) {
		switch(entityVar) {
		case "pk":
			return BaseModel.staticSolrPk(siteRequest_, (Long)o);
		case "inheritPk":
			return BaseModel.staticSolrInheritPk(siteRequest_, (String)o);
		case "id":
			return BaseModel.staticSolrId(siteRequest_, (String)o);
		case "created":
			return BaseModel.staticSolrCreated(siteRequest_, (ZonedDateTime)o);
		case "modified":
			return BaseModel.staticSolrModified(siteRequest_, (ZonedDateTime)o);
		case "archived":
			return BaseModel.staticSolrArchived(siteRequest_, (Boolean)o);
		case "deleted":
			return BaseModel.staticSolrDeleted(siteRequest_, (Boolean)o);
		case "classCanonicalName":
			return BaseModel.staticSolrClassCanonicalName(siteRequest_, (String)o);
		case "classSimpleName":
			return BaseModel.staticSolrClassSimpleName(siteRequest_, (String)o);
		case "classCanonicalNames":
			return BaseModel.staticSolrClassCanonicalNames(siteRequest_, (String)o);
		case "sessionId":
			return BaseModel.staticSolrSessionId(siteRequest_, (String)o);
		case "userId":
			return BaseModel.staticSolrUserId(siteRequest_, (String)o);
		case "userKey":
			return BaseModel.staticSolrUserKey(siteRequest_, (Long)o);
		case "saves":
			return BaseModel.staticSolrSaves(siteRequest_, (String)o);
		case "objectTitle":
			return BaseModel.staticSolrObjectTitle(siteRequest_, (String)o);
		case "objectId":
			return BaseModel.staticSolrObjectId(siteRequest_, (String)o);
		case "objectNameVar":
			return BaseModel.staticSolrObjectNameVar(siteRequest_, (String)o);
		case "objectSuggest":
			return BaseModel.staticSolrObjectSuggest(siteRequest_, (String)o);
		case "objectText":
			return BaseModel.staticSolrObjectText(siteRequest_, (String)o);
		case "pageUrlId":
			return BaseModel.staticSolrPageUrlId(siteRequest_, (String)o);
		case "pageUrlPk":
			return BaseModel.staticSolrPageUrlPk(siteRequest_, (String)o);
		case "pageUrlApi":
			return BaseModel.staticSolrPageUrlApi(siteRequest_, (String)o);
		case "pageH1":
			return BaseModel.staticSolrPageH1(siteRequest_, (String)o);
			default:
				return null;
		}
	}

	///////////////////
	// staticSolrStr //
	///////////////////

	public static String staticSolrStrForClass(String entityVar, SiteRequestEnUS siteRequest_, Object o) {
		return staticSolrStrBaseModel(entityVar,  siteRequest_, o);
	}
	public static String staticSolrStrBaseModel(String entityVar, SiteRequestEnUS siteRequest_, Object o) {
		switch(entityVar) {
		case "pk":
			return BaseModel.staticSolrStrPk(siteRequest_, (Long)o);
		case "inheritPk":
			return BaseModel.staticSolrStrInheritPk(siteRequest_, (String)o);
		case "id":
			return BaseModel.staticSolrStrId(siteRequest_, (String)o);
		case "created":
			return BaseModel.staticSolrStrCreated(siteRequest_, (Date)o);
		case "modified":
			return BaseModel.staticSolrStrModified(siteRequest_, (Date)o);
		case "archived":
			return BaseModel.staticSolrStrArchived(siteRequest_, (Boolean)o);
		case "deleted":
			return BaseModel.staticSolrStrDeleted(siteRequest_, (Boolean)o);
		case "classCanonicalName":
			return BaseModel.staticSolrStrClassCanonicalName(siteRequest_, (String)o);
		case "classSimpleName":
			return BaseModel.staticSolrStrClassSimpleName(siteRequest_, (String)o);
		case "classCanonicalNames":
			return BaseModel.staticSolrStrClassCanonicalNames(siteRequest_, (String)o);
		case "sessionId":
			return BaseModel.staticSolrStrSessionId(siteRequest_, (String)o);
		case "userId":
			return BaseModel.staticSolrStrUserId(siteRequest_, (String)o);
		case "userKey":
			return BaseModel.staticSolrStrUserKey(siteRequest_, (Long)o);
		case "saves":
			return BaseModel.staticSolrStrSaves(siteRequest_, (String)o);
		case "objectTitle":
			return BaseModel.staticSolrStrObjectTitle(siteRequest_, (String)o);
		case "objectId":
			return BaseModel.staticSolrStrObjectId(siteRequest_, (String)o);
		case "objectNameVar":
			return BaseModel.staticSolrStrObjectNameVar(siteRequest_, (String)o);
		case "objectSuggest":
			return BaseModel.staticSolrStrObjectSuggest(siteRequest_, (String)o);
		case "objectText":
			return BaseModel.staticSolrStrObjectText(siteRequest_, (String)o);
		case "pageUrlId":
			return BaseModel.staticSolrStrPageUrlId(siteRequest_, (String)o);
		case "pageUrlPk":
			return BaseModel.staticSolrStrPageUrlPk(siteRequest_, (String)o);
		case "pageUrlApi":
			return BaseModel.staticSolrStrPageUrlApi(siteRequest_, (String)o);
		case "pageH1":
			return BaseModel.staticSolrStrPageH1(siteRequest_, (String)o);
			default:
				return null;
		}
	}

	//////////////////
	// staticSolrFq //
	//////////////////

	public static String staticSolrFqForClass(String entityVar, SiteRequestEnUS siteRequest_, String o) {
		return staticSolrFqBaseModel(entityVar,  siteRequest_, o);
	}
	public static String staticSolrFqBaseModel(String entityVar, SiteRequestEnUS siteRequest_, String o) {
		switch(entityVar) {
		case "pk":
			return BaseModel.staticSolrFqPk(siteRequest_, o);
		case "inheritPk":
			return BaseModel.staticSolrFqInheritPk(siteRequest_, o);
		case "id":
			return BaseModel.staticSolrFqId(siteRequest_, o);
		case "created":
			return BaseModel.staticSolrFqCreated(siteRequest_, o);
		case "modified":
			return BaseModel.staticSolrFqModified(siteRequest_, o);
		case "archived":
			return BaseModel.staticSolrFqArchived(siteRequest_, o);
		case "deleted":
			return BaseModel.staticSolrFqDeleted(siteRequest_, o);
		case "classCanonicalName":
			return BaseModel.staticSolrFqClassCanonicalName(siteRequest_, o);
		case "classSimpleName":
			return BaseModel.staticSolrFqClassSimpleName(siteRequest_, o);
		case "classCanonicalNames":
			return BaseModel.staticSolrFqClassCanonicalNames(siteRequest_, o);
		case "sessionId":
			return BaseModel.staticSolrFqSessionId(siteRequest_, o);
		case "userId":
			return BaseModel.staticSolrFqUserId(siteRequest_, o);
		case "userKey":
			return BaseModel.staticSolrFqUserKey(siteRequest_, o);
		case "saves":
			return BaseModel.staticSolrFqSaves(siteRequest_, o);
		case "objectTitle":
			return BaseModel.staticSolrFqObjectTitle(siteRequest_, o);
		case "objectId":
			return BaseModel.staticSolrFqObjectId(siteRequest_, o);
		case "objectNameVar":
			return BaseModel.staticSolrFqObjectNameVar(siteRequest_, o);
		case "objectSuggest":
			return BaseModel.staticSolrFqObjectSuggest(siteRequest_, o);
		case "objectText":
			return BaseModel.staticSolrFqObjectText(siteRequest_, o);
		case "pageUrlId":
			return BaseModel.staticSolrFqPageUrlId(siteRequest_, o);
		case "pageUrlPk":
			return BaseModel.staticSolrFqPageUrlPk(siteRequest_, o);
		case "pageUrlApi":
			return BaseModel.staticSolrFqPageUrlApi(siteRequest_, o);
		case "pageH1":
			return BaseModel.staticSolrFqPageH1(siteRequest_, o);
			default:
				return null;
		}
	}

	/////////////
	// define //
	/////////////

	public boolean defineForClass(String var, String val) {
		String[] vars = StringUtils.split(var, ".");
		Object o = null;
		if(val != null) {
			for(String v : vars) {
				if(o == null)
					o = defineBaseModel(v, val);
				else if(o instanceof BaseModel) {
					BaseModel oBaseModel = (BaseModel)o;
					o = oBaseModel.defineForClass(v, val);
				}
			}
		}
		return o != null;
	}
	public Object defineBaseModel(String var, String val) {
		switch(var.toLowerCase()) {
			case "inheritpk":
				if(val != null)
					setInheritPk(val);
				saves.add("inheritPk");
				return val;
			case "created":
				if(val != null)
					setCreated(val);
				saves.add("created");
				return val;
			case "archived":
				if(val != null)
					setArchived(val);
				saves.add("archived");
				return val;
			case "deleted":
				if(val != null)
					setDeleted(val);
				saves.add("deleted");
				return val;
			case "userid":
				if(val != null)
					setUserId(val);
				saves.add("userId");
				return val;
			case "userkey":
				if(val != null)
					setUserKey(val);
				saves.add("userKey");
				return val;
			default:
				return null;
		}
	}

	public boolean defineForClass(String var, Object val) {
		String[] vars = StringUtils.split(var, ".");
		Object o = null;
		if(val != null) {
			for(String v : vars) {
				if(o == null)
					o = defineBaseModel(v, val);
				else if(o instanceof BaseModel) {
					BaseModel oBaseModel = (BaseModel)o;
					o = oBaseModel.defineForClass(v, val);
				}
			}
		}
		return o != null;
	}
	public Object defineBaseModel(String var, Object val) {
		switch(var.toLowerCase()) {
			case "inheritpk":
				if(val instanceof String)
					setInheritPk((String)val);
				saves.add("inheritPk");
				return val;
			case "created":
				if(val instanceof ZonedDateTime)
					setCreated((ZonedDateTime)val);
				else if(val instanceof OffsetDateTime)
					setCreated(((OffsetDateTime)val).atZoneSameInstant(ZoneId.of(siteRequest_.getConfig().getString(ConfigKeys.SITE_ZONE))));
				saves.add("created");
				return val;
			case "archived":
				if(val instanceof Boolean)
					setArchived((Boolean)val);
				saves.add("archived");
				return val;
			case "deleted":
				if(val instanceof Boolean)
					setDeleted((Boolean)val);
				saves.add("deleted");
				return val;
			case "userid":
				if(val instanceof String)
					setUserId((String)val);
				saves.add("userId");
				return val;
			case "userkey":
				if(val instanceof Long)
					setUserKey((Long)val);
				saves.add("userKey");
				return val;
			default:
				return null;
		}
	}

	/////////////
	// populate //
	/////////////

	public void populateForClass(SolrDocument solrDocument) {
		populateBaseModel(solrDocument);
	}
	public void populateBaseModel(SolrDocument solrDocument) {
		BaseModel oBaseModel = (BaseModel)this;
		saves = (List<String>)solrDocument.get("saves_stored_strings");
		if(saves != null) {
		}
	}

	public void indexBaseModel(SolrInputDocument document) {
		if(pk != null) {
			document.addField("pk_indexed_long", pk);
			document.addField("pk_stored_long", pk);
		}
		if(inheritPk != null) {
			document.addField("inheritPk_indexed_string", inheritPk);
			document.addField("inheritPk_stored_string", inheritPk);
		}
		if(id != null) {
			document.addField("id", id);
		}
		if(created != null) {
			document.addField("created_indexed_date", DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").format(ZonedDateTime.ofInstant(created.toInstant(), ZoneId.of("UTC"))));
			document.addField("created_stored_date", DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").format(ZonedDateTime.ofInstant(created.toInstant(), ZoneId.of("UTC"))));
		}
		if(modified != null) {
			document.addField("modified_indexed_date", DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").format(ZonedDateTime.ofInstant(modified.toInstant(), ZoneId.of("UTC"))));
			document.addField("modified_stored_date", DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").format(ZonedDateTime.ofInstant(modified.toInstant(), ZoneId.of("UTC"))));
		}
		if(archived != null) {
			document.addField("archived_indexed_boolean", archived);
			document.addField("archived_stored_boolean", archived);
		}
		if(deleted != null) {
			document.addField("deleted_indexed_boolean", deleted);
			document.addField("deleted_stored_boolean", deleted);
		}
		if(classCanonicalName != null) {
			document.addField("classCanonicalName_indexed_string", classCanonicalName);
			document.addField("classCanonicalName_stored_string", classCanonicalName);
		}
		if(classSimpleName != null) {
			document.addField("classSimpleName_indexed_string", classSimpleName);
			document.addField("classSimpleName_stored_string", classSimpleName);
		}
		if(classCanonicalNames != null) {
			for(java.lang.String o : classCanonicalNames) {
				document.addField("classCanonicalNames_indexed_strings", o);
			}
			for(java.lang.String o : classCanonicalNames) {
				document.addField("classCanonicalNames_stored_strings", o);
			}
		}
		if(sessionId != null) {
			document.addField("sessionId_indexed_string", sessionId);
			document.addField("sessionId_stored_string", sessionId);
		}
		if(userId != null) {
			document.addField("userId_indexed_string", userId);
			document.addField("userId_stored_string", userId);
		}
		if(userKey != null) {
			document.addField("userKey_indexed_long", userKey);
			document.addField("userKey_stored_long", userKey);
		}
		if(saves != null) {
			for(java.lang.String o : saves) {
				document.addField("saves_indexed_strings", o);
			}
			for(java.lang.String o : saves) {
				document.addField("saves_stored_strings", o);
			}
		}
		if(objectTitle != null) {
			document.addField("objectTitle_indexed_string", objectTitle);
			document.addField("objectTitle_stored_string", objectTitle);
		}
		if(objectId != null) {
			document.addField("objectId_indexed_string", objectId);
			document.addField("objectId_stored_string", objectId);
		}
		if(objectSuggest != null) {
			document.addField("objectSuggest_suggested", objectSuggest);
		}
		if(objectText != null) {
			document.addField("objectText_text_enUS", objectText.toString());
			document.addField("objectText_indexed_string", objectText);
		}
		if(pageUrlId != null) {
			document.addField("pageUrlId_indexed_string", pageUrlId);
			document.addField("pageUrlId_stored_string", pageUrlId);
		}
		if(pageUrlPk != null) {
			document.addField("pageUrlPk_indexed_string", pageUrlPk);
			document.addField("pageUrlPk_stored_string", pageUrlPk);
		}
	}

	public static String varIndexedBaseModel(String entityVar) {
		switch(entityVar) {
			case "pk":
				return "pk_indexed_long";
			case "inheritPk":
				return "inheritPk_indexed_string";
			case "id":
				return "id";
			case "created":
				return "created_indexed_date";
			case "modified":
				return "modified_indexed_date";
			case "archived":
				return "archived_indexed_boolean";
			case "deleted":
				return "deleted_indexed_boolean";
			case "classCanonicalName":
				return "classCanonicalName_indexed_string";
			case "classSimpleName":
				return "classSimpleName_indexed_string";
			case "classCanonicalNames":
				return "classCanonicalNames_indexed_strings";
			case "sessionId":
				return "sessionId_indexed_string";
			case "userId":
				return "userId_indexed_string";
			case "userKey":
				return "userKey_indexed_long";
			case "saves":
				return "saves_indexed_strings";
			case "objectTitle":
				return "objectTitle_indexed_string";
			case "objectId":
				return "objectId_indexed_string";
			case "objectSuggest":
				return "objectSuggest_suggested";
			case "objectText":
				return "objectText_text_enUS";
			case "pageUrlId":
				return "pageUrlId_indexed_string";
			case "pageUrlPk":
				return "pageUrlPk_indexed_string";
			default:
				return null;
		}
	}

	public static String varSearchBaseModel(String entityVar) {
		switch(entityVar) {
			case "objectText":
				return "objectText_text_enUS";
			case "objectSuggest":
				return "objectSuggest_suggested";
			default:
				return null;
		}
	}

	public static String varSuggestedBaseModel(String entityVar) {
		switch(entityVar) {
			case "objectSuggest":
				return "objectSuggest_suggested";
			default:
				return null;
		}
	}

	/////////////
	// store //
	/////////////

	public void storeForClass(SolrDocument solrDocument) {
		storeBaseModel(solrDocument);
	}
	public void storeBaseModel(SolrDocument solrDocument) {
		BaseModel oBaseModel = (BaseModel)this;

		oBaseModel.setPk(Optional.ofNullable(solrDocument.get("pk_stored_long")).map(v -> v.toString()).orElse(null));
		oBaseModel.setInheritPk(Optional.ofNullable(solrDocument.get("inheritPk_stored_string")).map(v -> v.toString()).orElse(null));
		String id = (String)solrDocument.get("id");
		oBaseModel.setId(id);
		oBaseModel.setCreated(Optional.ofNullable(solrDocument.get("created_stored_date")).map(v -> v.toString()).orElse(null));
		oBaseModel.setModified(Optional.ofNullable(solrDocument.get("modified_stored_date")).map(v -> v.toString()).orElse(null));
		oBaseModel.setArchived(Optional.ofNullable(solrDocument.get("archived_stored_boolean")).map(v -> v.toString()).orElse(null));
		oBaseModel.setDeleted(Optional.ofNullable(solrDocument.get("deleted_stored_boolean")).map(v -> v.toString()).orElse(null));
		oBaseModel.setClassCanonicalName(Optional.ofNullable(solrDocument.get("classCanonicalName_stored_string")).map(v -> v.toString()).orElse(null));
		oBaseModel.setClassSimpleName(Optional.ofNullable(solrDocument.get("classSimpleName_stored_string")).map(v -> v.toString()).orElse(null));
		Optional.ofNullable((List<?>)solrDocument.get("classCanonicalNames_stored_strings")).orElse(Arrays.asList()).stream().filter(v -> v != null).forEach(v -> {
			oBaseModel.addClassCanonicalNames(v.toString());
		});
		oBaseModel.setSessionId(Optional.ofNullable(solrDocument.get("sessionId_stored_string")).map(v -> v.toString()).orElse(null));
		oBaseModel.setUserId(Optional.ofNullable(solrDocument.get("userId_stored_string")).map(v -> v.toString()).orElse(null));
		oBaseModel.setUserKey(Optional.ofNullable(solrDocument.get("userKey_stored_long")).map(v -> v.toString()).orElse(null));
		Optional.ofNullable((List<?>)solrDocument.get("saves_stored_strings")).orElse(Arrays.asList()).stream().filter(v -> v != null).forEach(v -> {
			oBaseModel.addSaves(v.toString());
		});
		oBaseModel.setObjectTitle(Optional.ofNullable(solrDocument.get("objectTitle_stored_string")).map(v -> v.toString()).orElse(null));
		oBaseModel.setObjectId(Optional.ofNullable(solrDocument.get("objectId_stored_string")).map(v -> v.toString()).orElse(null));
		String objectSuggest = (String)solrDocument.get("objectSuggest_suggested");
		oBaseModel.setObjectSuggest(objectSuggest);
		oBaseModel.setObjectText(Optional.ofNullable(solrDocument.get("objectText_stored_string")).map(v -> v.toString()).orElse(null));
		oBaseModel.setPageUrlId(Optional.ofNullable(solrDocument.get("pageUrlId_stored_string")).map(v -> v.toString()).orElse(null));
		oBaseModel.setPageUrlPk(Optional.ofNullable(solrDocument.get("pageUrlPk_stored_string")).map(v -> v.toString()).orElse(null));
	}

	//////////////////
	// apiRequest //
	//////////////////

	public void apiRequestBaseModel() {
		ApiRequest apiRequest = Optional.ofNullable(siteRequest_).map(SiteRequestEnUS::getApiRequest_).orElse(null);
		Object o = Optional.ofNullable(apiRequest).map(ApiRequest::getOriginal).orElse(null);
		if(o != null && o instanceof BaseModel) {
			BaseModel original = (BaseModel)o;
			if(!Objects.equals(pk, original.getPk()))
				apiRequest.addVars("pk");
			if(!Objects.equals(inheritPk, original.getInheritPk()))
				apiRequest.addVars("inheritPk");
			if(!Objects.equals(id, original.getId()))
				apiRequest.addVars("id");
			if(!Objects.equals(created, original.getCreated()))
				apiRequest.addVars("created");
			if(!Objects.equals(modified, original.getModified()))
				apiRequest.addVars("modified");
			if(!Objects.equals(archived, original.getArchived()))
				apiRequest.addVars("archived");
			if(!Objects.equals(deleted, original.getDeleted()))
				apiRequest.addVars("deleted");
			if(!Objects.equals(classCanonicalName, original.getClassCanonicalName()))
				apiRequest.addVars("classCanonicalName");
			if(!Objects.equals(classSimpleName, original.getClassSimpleName()))
				apiRequest.addVars("classSimpleName");
			if(!Objects.equals(classCanonicalNames, original.getClassCanonicalNames()))
				apiRequest.addVars("classCanonicalNames");
			if(!Objects.equals(sessionId, original.getSessionId()))
				apiRequest.addVars("sessionId");
			if(!Objects.equals(userId, original.getUserId()))
				apiRequest.addVars("userId");
			if(!Objects.equals(userKey, original.getUserKey()))
				apiRequest.addVars("userKey");
			if(!Objects.equals(saves, original.getSaves()))
				apiRequest.addVars("saves");
			if(!Objects.equals(objectTitle, original.getObjectTitle()))
				apiRequest.addVars("objectTitle");
			if(!Objects.equals(objectId, original.getObjectId()))
				apiRequest.addVars("objectId");
			if(!Objects.equals(objectSuggest, original.getObjectSuggest()))
				apiRequest.addVars("objectSuggest");
			if(!Objects.equals(objectText, original.getObjectText()))
				apiRequest.addVars("objectText");
			if(!Objects.equals(pageUrlId, original.getPageUrlId()))
				apiRequest.addVars("pageUrlId");
			if(!Objects.equals(pageUrlPk, original.getPageUrlPk()))
				apiRequest.addVars("pageUrlPk");
		}
	}

	//////////////
	// hashCode //
	//////////////

	@Override public int hashCode() {
		return Objects.hash(pk, inheritPk, id, created, modified, archived, deleted, classCanonicalName, classSimpleName, classCanonicalNames, sessionId, userId, userKey, saves, objectTitle, objectId, objectSuggest, objectText, pageUrlId, pageUrlPk);
	}

	////////////
	// equals //
	////////////

	@Override public boolean equals(Object o) {
		if(this == o)
			return true;
		if(!(o instanceof BaseModel))
			return false;
		BaseModel that = (BaseModel)o;
		return Objects.equals( pk, that.pk )
				&& Objects.equals( inheritPk, that.inheritPk )
				&& Objects.equals( id, that.id )
				&& Objects.equals( created, that.created )
				&& Objects.equals( modified, that.modified )
				&& Objects.equals( archived, that.archived )
				&& Objects.equals( deleted, that.deleted )
				&& Objects.equals( classCanonicalName, that.classCanonicalName )
				&& Objects.equals( classSimpleName, that.classSimpleName )
				&& Objects.equals( classCanonicalNames, that.classCanonicalNames )
				&& Objects.equals( sessionId, that.sessionId )
				&& Objects.equals( userId, that.userId )
				&& Objects.equals( userKey, that.userKey )
				&& Objects.equals( saves, that.saves )
				&& Objects.equals( objectTitle, that.objectTitle )
				&& Objects.equals( objectId, that.objectId )
				&& Objects.equals( objectSuggest, that.objectSuggest )
				&& Objects.equals( objectText, that.objectText )
				&& Objects.equals( pageUrlId, that.pageUrlId )
				&& Objects.equals( pageUrlPk, that.pageUrlPk );
	}

	//////////////
	// toString //
	//////////////

	@Override public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("BaseModel { ");
		sb.append( "pk: " ).append(pk);
		sb.append( ", inheritPk: \"" ).append(inheritPk).append( "\"" );
		sb.append( ", id: \"" ).append(id).append( "\"" );
		sb.append( ", created: " ).append(created);
		sb.append( ", modified: " ).append(modified);
		sb.append( ", archived: " ).append(archived);
		sb.append( ", deleted: " ).append(deleted);
		sb.append( ", classCanonicalName: \"" ).append(classCanonicalName).append( "\"" );
		sb.append( ", classSimpleName: \"" ).append(classSimpleName).append( "\"" );
		sb.append( ", classCanonicalNames: " ).append(classCanonicalNames);
		sb.append( ", sessionId: \"" ).append(sessionId).append( "\"" );
		sb.append( ", userId: \"" ).append(userId).append( "\"" );
		sb.append( ", userKey: " ).append(userKey);
		sb.append( ", saves: " ).append(saves);
		sb.append( ", objectTitle: \"" ).append(objectTitle).append( "\"" );
		sb.append( ", objectId: \"" ).append(objectId).append( "\"" );
		sb.append( ", objectSuggest: \"" ).append(objectSuggest).append( "\"" );
		sb.append( ", objectText: \"" ).append(objectText).append( "\"" );
		sb.append( ", pageUrlId: \"" ).append(pageUrlId).append( "\"" );
		sb.append( ", pageUrlPk: \"" ).append(pageUrlPk).append( "\"" );
		sb.append(" }");
		return sb.toString();
	}

	public static final String VAR_siteRequest_ = "siteRequest_";
	public static final String VAR_pk = "pk";
	public static final String VAR_inheritPk = "inheritPk";
	public static final String VAR_id = "id";
	public static final String VAR_created = "created";
	public static final String VAR_modified = "modified";
	public static final String VAR_archived = "archived";
	public static final String VAR_deleted = "deleted";
	public static final String VAR_classCanonicalName = "classCanonicalName";
	public static final String VAR_classSimpleName = "classSimpleName";
	public static final String VAR_classCanonicalNames = "classCanonicalNames";
	public static final String VAR_sessionId = "sessionId";
	public static final String VAR_userId = "userId";
	public static final String VAR_userKey = "userKey";
	public static final String VAR_saves = "saves";
	public static final String VAR_objectTitle = "objectTitle";
	public static final String VAR_objectId = "objectId";
	public static final String VAR_objectNameVar = "objectNameVar";
	public static final String VAR_objectSuggest = "objectSuggest";
	public static final String VAR_objectText = "objectText";
	public static final String VAR_pageUrlId = "pageUrlId";
	public static final String VAR_pageUrlPk = "pageUrlPk";
	public static final String VAR_pageUrlApi = "pageUrlApi";
	public static final String VAR_pageH1 = "pageH1";
}