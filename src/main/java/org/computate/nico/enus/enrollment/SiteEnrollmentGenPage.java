package org.computate.nico.enus.enrollment;

import java.lang.Long;
import java.util.List;
import org.computate.nico.enus.search.SearchList;
import org.computate.nico.enus.pet.SitePet;
import org.computate.nico.enus.page.PageLayout;
import org.computate.nico.enus.request.SiteRequestEnUS;
import org.computate.nico.enus.user.SiteUser;
import java.io.IOException;
import io.vertx.core.http.HttpServerRequest;
import io.vertx.core.http.HttpServerResponse;
import org.computate.nico.enus.wrap.Wrap;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.api.service.ServiceRequest;
import io.vertx.core.json.JsonArray;
import java.net.URLDecoder;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.commons.lang3.StringUtils;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;
import org.apache.solr.common.util.SimpleOrderedMap;
import java.util.stream.Collectors;
import java.util.Arrays;
import org.apache.solr.client.solrj.response.QueryResponse;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.math.MathContext;
import org.apache.commons.collections.CollectionUtils;
import java.util.Objects;
import org.apache.solr.client.solrj.SolrQuery.SortClause;
import io.vertx.core.Promise;
import org.computate.nico.enus.config.ConfigKeys;


/**
 * Translate: false
 **/
public class SiteEnrollmentGenPage extends SiteEnrollmentGenPageGen<PageLayout> {

	/**
	 * {@inheritDoc}
	 * Ignore: true
	 **/
	protected void _searchListSiteEnrollment_(Wrap<SearchList<SiteEnrollment>> w) {
	}

	/**
	 * {@inheritDoc}
	 **/
	protected void _listSiteEnrollment(JsonArray l) {
		Optional.ofNullable(searchListSiteEnrollment_).map(o -> o.getList()).orElse(Arrays.asList()).stream().map(o -> JsonObject.mapFrom(o)).forEach(o -> l.add(o));
	}

	protected void _siteEnrollmentCount(Wrap<Integer> w) {
		w.o(searchListSiteEnrollment_ == null ? 0 : searchListSiteEnrollment_.size());
	}

	protected void _siteEnrollment_(Wrap<SiteEnrollment> w) {
		if(siteEnrollmentCount == 1)
			w.o(searchListSiteEnrollment_.get(0));
	}

	protected void _pk(Wrap<Long> w) {
		if(siteEnrollmentCount == 1)
			w.o(siteEnrollment_.getPk());
	}

	@Override
	protected void _promiseBefore(Promise<Void> promise) {
		promise.complete();
	}

	@Override
	protected void _classSimpleName(Wrap<String> w) {
		w.o("SiteEnrollment");
	}

	@Override
	protected void _pageTitle(Wrap<String> c) {
		if(siteEnrollment_ != null && siteEnrollment_.getObjectTitle() != null)
			c.o(siteEnrollment_.getObjectTitle());
		else if(siteEnrollment_ != null)
			c.o("enrollments");
		else if(searchListSiteEnrollment_ == null || siteEnrollmentCount == 0)
			c.o("no enrollment found");
		else
			c.o("enrollments");
	}

	@Override
	protected void _pageUri(Wrap<String> c) {
		c.o("/api/enrollment");
	}

	@Override
	protected void _roles(List<String> l) {
		if(siteRequest_ != null) {
			l.addAll(Stream.concat(siteRequest_.getUserResourceRoles().stream(), siteRequest_.getUserRealmRoles().stream()).distinct().collect(Collectors.toList()));
		}
	}

	@Override
	protected void _rolesRequired(List<String> l) {
		l.addAll(Optional.ofNullable(siteRequest_.getConfig().getJsonArray(ConfigKeys.AUTH_ROLES_REQUIRED + "_SiteEnrollment")).orElse(new JsonArray()).stream().map(o -> o.toString()).collect(Collectors.toList()));
	}

	@Override
	protected void _pagination(JsonObject pagination) {
		JsonArray pages = new JsonArray();
		Long start = searchListSiteEnrollment_.getStart().longValue();
		Long rows = searchListSiteEnrollment_.getRows().longValue();
		Long foundNum = searchListSiteEnrollment_.getQueryResponse().getResults().getNumFound();
		Long startNum = start + 1L;
		Long endNum = start + rows;
		Long floorMod = Math.floorMod(foundNum, rows);
		Long last = Math.floorDiv(foundNum, rows) - (floorMod.equals(0L) ? 1L : 0L) * rows;
		endNum = endNum < foundNum ? endNum : foundNum;
		startNum = foundNum == 0L ? 0L : startNum;
		Long paginationStart = start - 10L * rows;
		if(paginationStart < 0L)
			paginationStart = 0L;
		Long paginationEnd = start + 10L * rows;
		if(paginationEnd > foundNum)
			paginationEnd = foundNum;

		pagination.put("1L", 1L);
		pagination.put("0L", 0L);
		pagination.put("start", start);
		pagination.put("rows", rows);
		pagination.put("rowsPrevious", rows / 2);
		pagination.put("rowsNext", rows * 2);
		pagination.put("startNum", startNum);
		pagination.put("endNum", endNum);
		pagination.put("foundNum", foundNum);
		pagination.put("pageStart", new JsonObject().put("start", 0L).put("pageNumber", 1L));
		if(start > 0L)
			pagination.put("pagePrevious", new JsonObject().put("start", start - rows).put("pageNumber", start - rows + 1L));
		if(start + rows < foundNum)
			pagination.put("pageNext", new JsonObject().put("start", start + rows).put("pageNumber", start + rows + 1L));
		pagination.put("pageEnd", new JsonObject().put("start", last).put("pageNumber", last + 1L));
		pagination.put("pages", pages);
		for(Long i = paginationStart; i < paginationEnd; i += rows) {
			Long pageNumber = Math.floorDiv(i, rows) + 1L;
			JsonObject page = new JsonObject();
			page.put("pageNumber", pageNumber);
			page.put("currentPage", start.equals(i));
			page.put("start", i);
			pages.add(page);
		}
	}

	@Override
	protected void _query(JsonObject query) {
		ServiceRequest serviceRequest = siteRequest_.getServiceRequest();
		JsonObject params = serviceRequest.getParams();

		JsonObject queryParams = Optional.ofNullable(serviceRequest).map(ServiceRequest::getParams).map(or -> or.getJsonObject("query")).orElse(new JsonObject());
		Long num = searchListSiteEnrollment_.getQueryResponse().getResults().getNumFound();
		String q = "*:*";
		String q1 = "objectText";
		String q2 = "";
		for(String paramName : queryParams.fieldNames()) {
			String entityVar = null;
			String valueIndexed = null;
			Object paramObjectValues = queryParams.getValue(paramName);
			JsonArray paramObjects = paramObjectValues instanceof JsonArray ? (JsonArray)paramObjectValues : new JsonArray().add(paramObjectValues);

			try {
				for(Object paramObject : paramObjects) {
					switch(paramName) {
					case "q":
						q = (String)paramObject;
						entityVar = StringUtils.trim(StringUtils.substringBefore((String)paramObject, ":"));
						valueIndexed = URLDecoder.decode(StringUtils.trim(StringUtils.substringAfter((String)paramObject, ":")), "UTF-8");
						q1 = entityVar.equals("*") ? q1 : entityVar;
						q2 = valueIndexed;
						q = q1 + ":" + q2;
					}
				}
			} catch(Exception e) {
				ExceptionUtils.rethrow(e);
			}
		}
		query.put("q", q);

		Integer rows1 = Optional.ofNullable(searchListSiteEnrollment_).map(l -> l.getRows()).orElse(10);
		Integer start1 = Optional.ofNullable(searchListSiteEnrollment_).map(l -> l.getStart()).orElse(1);
		Integer start2 = start1 - rows1;
		Integer start3 = start1 + rows1;
		Integer rows2 = rows1 / 2;
		Integer rows3 = rows1 * 2;
		start2 = start2 < 0 ? 0 : start2;
		JsonArray fqs = new JsonArray();
		for(String fq : Optional.ofNullable(searchListSiteEnrollment_).map(l -> l.getFilterQueries()).orElse(new String[0])) {
			if(!StringUtils.contains(fq, "(")) {
				String fq1 = StringUtils.substringBefore(fq, "_");
				String fq2 = StringUtils.substringAfter(fq, ":");
				if(!StringUtils.startsWithAny(fq, "classCanonicalNames_", "archived_", "deleted_", "sessionId", "userKeys"))
					fqs.add(new JsonObject().put("var", fq1).put("val", fq2));
				}
			}
		query.put("fq", fqs);

		JsonArray sorts = new JsonArray();
		for(SortClause sort : Optional.ofNullable(searchListSiteEnrollment_).map(l -> l.getSorts()).orElse(Arrays.asList())) {
			sorts.add(new JsonObject().put("var", StringUtils.substringBefore(sort.getItem(), "_")).put("order", sort.getOrder().name()));
		}
		query.put("sort", sorts);
	}

	@Override
	protected void _promiseAfter(Promise<Void> promise) {
		promise.complete();
	}

	@Override
	protected void _pageImageUri(Wrap<String> c) {
			c.o("/png/api/enrollment-999.png");
	}

	@Override
	protected void _contextIconGroup(Wrap<String> c) {
			c.o("duotone");
	}

	@Override
	protected void _contextIconName(Wrap<String> c) {
			c.o("clipboard-list");
	}
}
