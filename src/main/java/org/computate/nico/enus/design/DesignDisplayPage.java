package org.computate.nico.enus.design;

import java.util.List;

import org.apache.solr.client.solrj.SolrQuery.ORDER;
import org.computate.nico.enus.html.part.HtmlPart;
import org.computate.nico.enus.search.SearchList;
import org.computate.nico.enus.wrap.Wrap;

/**
 * Translate: false
 **/
public class DesignDisplayPage extends DesignDisplayPageGen<DesignDisplayGenPage> {

	/**
	 * {@inheritDoc}
	 * 
	 **/
	protected void _pageDesign(Wrap<PageDesign> c) {
		if(listPageDesign.size() == 1) {
			PageDesign o = listPageDesign.get(0);
			setPageContentType(o.getPageContentType());
			siteRequest_.getRequestHeaders().set("Content-Type", o.getPageContentType());
			c.o(o);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 **/
	protected void _pageDesignId(Wrap<String> c) {
		if(pageDesign != null)
			c.o(pageDesign.getObjectId());
	}

	/**
	 * {@inheritDoc}
	 * 
	 **/
	protected void _htmlPartSearch(SearchList<HtmlPart> l) {
		if(pageDesign != null) {
			l.setQuery("*:*");

			StringBuilder fq = new StringBuilder();
			fq.append("pageDesignKeys_indexed_longs:").append(pageDesign.getPk());
			for(Long k : pageDesign.getParentDesignKeys())
				fq.append(" OR pageDesignKeys_indexed_longs:").append(k);

			l.addFilterQuery(fq.toString());
			l.addFilterQuery("archived_indexed_boolean:false");
			l.addFilterQuery("deleted_indexed_boolean:false");
			l.setC(HtmlPart.class);
			l.setStore(true);
			l.addSort("sort1_indexed_double", ORDER.asc);
			l.addSort("sort2_indexed_double", ORDER.asc);
			l.addSort("sort3_indexed_double", ORDER.asc);
			l.addSort("sort4_indexed_double", ORDER.asc);
			l.addSort("sort5_indexed_double", ORDER.asc);
			l.addSort("sort6_indexed_double", ORDER.asc);
			l.addSort("sort7_indexed_double", ORDER.asc);
			l.addSort("sort8_indexed_double", ORDER.asc);
			l.addSort("sort9_indexed_double", ORDER.asc);
			l.addSort("sort10_indexed_double", ORDER.asc);
			l.setRows(100000);
		}
	}

	protected void _htmlPartList(Wrap<List<HtmlPart>> c) {
		if(htmlPartSearch.size() > 0)
			c.o(htmlPartSearch.getList());
	}

	@Override public void htmlPageLayout() {
		if(htmlPartList != null) {
			htmlPageLayout2(pageContentType, htmlPartList, null, 0, htmlPartList.size());
		}
	}
}
