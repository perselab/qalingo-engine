/**
 * Most of the code in the Qalingo project is copyrighted Hoteia and licensed
 * under the Apache License Version 2.0 (release version 0.8.0)
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 *                   Copyright (c) Hoteia, 2012-2014
 * http://www.hoteia.com - http://twitter.com/hoteia - contact@hoteia.com
 *
 */
package org.hoteia.qalingo.core.service;

import java.util.List;

import org.hoteia.qalingo.core.domain.CatalogMaster;
import org.hoteia.qalingo.core.domain.CatalogVirtual;

public interface CatalogService {

    CatalogMaster getMasterCatalogById(Long masterCatalogId, Object... params);
    
	CatalogMaster getMasterCatalogById(String masterCatalogId, Object... params);

	CatalogVirtual getVirtualCatalogById(Long virtualCatalogId, Object... params);
    
	CatalogVirtual getVirtualCatalogById(String virtualCatalogId, Object... params);

	CatalogVirtual getVirtualCatalogbyMarketAreaId(Long marketAreaId, Object... params);

    List<CatalogMaster> findAllCatalogMasters(Object... params);

	void saveOrUpdateCatalogMaster(CatalogMaster masterCatalog);
	
	void deleteCatalogMaster(CatalogMaster masterCatalog);

}
