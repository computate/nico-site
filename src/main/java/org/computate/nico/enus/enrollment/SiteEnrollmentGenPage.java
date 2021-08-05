package org.computate.nico.enus.enrollment;

import org.computate.nico.enus.request.SiteRequestEnUS;
import org.computate.nico.enus.user.SiteUser;
import java.io.IOException;
import io.vertx.core.http.HttpServerRequest;
import io.vertx.core.http.HttpServerResponse;
import org.computate.nico.enus.search.SearchList;
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
import java.util.List;
import java.util.Optional;
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


/**
 * Translate: false
 **/
public class SiteEnrollmentGenPage extends SiteEnrollmentGenPageGen<Object> {

	public static final List<String> ROLES = Arrays.asList("SiteAdmin");
	public static final List<String> ROLE_READS = Arrays.asList("");

	/**
	 * {@inheritDoc}
	 * 
	 **/
	protected void _listSiteEnrollment(Wrap<SearchList<SiteEnrollment>> c) {
	}

	protected void _siteEnrollment_(Wrap<SiteEnrollment> c) {
		if(listSiteEnrollment != null && listSiteEnrollment.size() == 1)
			c.o(listSiteEnrollment.get(0));
	}

	protected void _pageH1(Wrap<String> c) {
			c.o("enrollments");
	}

	protected void _pageH2(Wrap<String> c) {
		c.o("");
	}

	protected void _pageH3(Wrap<String> c) {
		c.o("");
	}

	protected void _pageTitle(Wrap<String> c) {
		if(siteEnrollment_ != null && siteEnrollment_.getObjectTitle() != null)
			c.o(siteEnrollment_.getObjectTitle());
		else if(siteEnrollment_ != null)
			c.o("enrollments");
		else if(listSiteEnrollment == null || listSiteEnrollment.size() == 0)
			c.o("no enrollment found");
		else
			c.o("enrollments");
	}

	protected void _pageUri(Wrap<String> c) {
		c.o("/api/enrollment");
	}

	protected void _pageImageUri(Wrap<String> c) {
			c.o("/png/api/enrollment-999.png");
	}

	protected void _contextIconGroup(Wrap<String> c) {
			c.o("duotone");
	}

	protected void _contextIconName(Wrap<String> c) {
			c.o("clipboard-list");
	}

	public void initDeepSiteEnrollmentGenPage() {
		initSiteEnrollmentGenPage();
	}
}
