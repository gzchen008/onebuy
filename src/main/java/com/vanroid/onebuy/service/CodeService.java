package com.vanroid.onebuy.service;

import java.util.Set;

import com.vanroid.onebuy.entity.Code;
import com.vanroid.onebuy.entity.Stage;

/**
 * 
*  @company vanroid.com
 * @author cgz
 * @date 2016年1月23日
 * @version 1.0
 * @description TODO
 */
public interface CodeService extends BaseService<Code>{

	Set<Code> findByStage(Stage stage);

}
