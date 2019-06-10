# kitty-generator

### 项目介绍

Kitty代码生成器，可以通过界面配置快速生成包括 model，dao，service，controller 以及页面的相关代码。

### 在线演示

演示地址：http://139.196.87.48:9002/kitty

用户名：admin 密码：admin

温馨提示：
有在演示环境删除数据的童鞋们，如果可以的话，麻烦动动小指，右键头像菜单，
选择 -> 备份还原 帮忙恢复到系统默认备份数据，方便后来的童鞋查看，谢谢啦。

### 技术交流

为了方便大家提问和技术交流，整了个QQ群，欢迎童鞋们加入。

QQ技术交流群： 429854222

### 功能列表

- ✔ 数据源配置：配置连接和测试数据源
- ✔ 单表查询：生成单表增删改查的代码
- ✘ 主从表格：生成主从表增删改查的代码
- ✘ 单表树形：生成单表树形结构的操作代码
- ...

### 软件架构

#### 后端架构

##### 开发环境

- IDE : eclipse 4.x
- JDK : JDK1.8.x
- Maven : Maven 3.5.x
- MySQL: MySQL 5.7.x

##### 技术选型

- 核心框架：Spring Boot 2.x
- 视图框架：Spring MVC 5.x
- 持久层框架：MyBatis 3.x
- 模板技术：beetl 1.1.68
- XML解析：dom4j 1.6.x
- JSON工具：fastjson 1.2.x

##### 项目结构

- kitty-generator-pom： 聚合打包模块
- kitty-generator： 代码生成服务模块
- kitty-dbms： 数据库操作业务封装模块
- kitty-core： 核心代码模块，封装公共业务模块
- kitty-common： 公共代码模块，放置一些工具类

#### 前端架构

##### 开发环境

- IDE : VS Code 1.27
- NODE: Node 8.9.x
- NPM : NPM 6.4.x

##### 技术选型

- 前端框架：Vue 2.x
- 页面组件：Element 2.x
- 状态管理：Vuex 2.x
- 后台交互：axios 0.18.x
- 图标使用：Font Awesome 4.x

##### 项目结构

kitty-generator-ui
- assets： 图标、字体、国际化信息等静态信息
- components： 组件库，对常用组件进行封装
- i18n： 国际化模块，使用Vue i18n进行国际化
- mock： Mock模块，模拟接口调用并返回定制数据
- router： 路由管理模块，负责页面各种路由配置
- store： 状态管理模块，提供组件间状态共享
- utils： 工具模块，提供一些通用的工具方法
- views： 页面模块，主要放置各种页面视图组件

### 安装教程

1. 下载war包

![输入图片说明](https://images.gitee.com/uploads/images/2018/1115/172326_5ee79ca4_645970.png "屏幕截图.png")

2. 去掉后缀

![输入图片说明](https://images.gitee.com/uploads/images/2018/1115/172603_5d3e3dbd_645970.png "屏幕截图.png")

3. 修改地址

![输入图片说明](https://images.gitee.com/uploads/images/2018/1115/172946_66c49374_645970.png "屏幕截图.png")

4. 启动服务

启动 Tomcat， 通过浏览器查看，如端口是8080，则访问地址为： http://localhost:8080/kitty-generator 。

![输入图片说明](https://images.gitee.com/uploads/images/2018/1115/173240_8a58507f_645970.png "屏幕截图.png")


### 源码安装教程

#### 后端安装

1. 下载源码

    git clone https://gitee.com/liuge1988/kitty-generator.git

2. 导入工程

    使用 Eclipse导入 Maven 项目，在此之前请确认已安装 JDK 和 Maven 工具。

3. 编译代码

    找到 kitty-generator-pom 工程的 pom.xml，执行 maven clean install 命令编译一键打包。

    一般来说不会有什么问题，如果还是编译不成功，可以按照优先级逐个编译试一试。

4. 导入数据库

    为了方便测试，模块集成了Mybatis模块，如果启动报出Mybatis数据连接错误，遵循如下操作。

    修改 kitty-generator 下 application.yml 中的数据库连接和账号密码为可用的数据库配置。

5. 启动系统

    找到 kitty-generator工程下的 KittyGeneratorApplication， 启动项目，开启代码生成服务。
    
#### 前端安装

1. 下载源码

    git clone https://gitee.com/liuge1988/kitty-generator.git

2. 编译代码

    进入 kitty-generator-ui 根目录，执行 npm install, 下载和安装项目相关依赖包。

3. 启动系统

    执行 npm run dev 命令，启动项目，通过 http://localhost:8888 访问。

4. 项目打包

    执行 npm run build 命令，启动打包，完成之后会生成 dist 目录。

5. 修改配置

    如果想自定义端口（默认是8888），可以修改 config/index.js 下的 port 属性。

    后台服务接口服务器地址配置在 src/utils/global.js，后台如有修改请做相应变更。

    
### 使用指南

#### 1.配置数据源

![输入图片说明](https://images.gitee.com/uploads/images/2018/1114/180145_1b395632_645970.png "屏幕截图.png")

#### 2.选择数据库表

![输入图片说明](https://images.gitee.com/uploads/images/2018/1114/180317_ca91ceb2_645970.png "屏幕截图.png")

#### 3.编辑信息，生成代码

![输入图片说明](https://images.gitee.com/uploads/images/2018/1114/180642_2c4f986d_645970.png "屏幕截图.png")


### 代码样例

#### Model 代码样例

```
package com.louis.kitty.model;

/**
 * ---------------------------
 * 字典表 (SysDict)         
 * ---------------------------
 * 作者：  kitty-generator
 * 时间：  2018-11-14 17:24:01
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
public class SysDict {

	/** 编号 */
	private Long id;
	/** 数据值 */
	private String value;
	/** 标签名 */
	private String label;
	/** 类型 */
	private String type;
	/** 描述 */
	private String description;
	/** 排序（升序） */
	private Double sort;
	/** 创建人 */
	private String createBy;
	/** 创建时间 */
	private java.util.Date createTime;
	/** 更新人 */
	private String lastUpdateBy;
	/** 更新时间 */
	private java.util.Date lastUpdateTime;
	/** 备注信息 */
	private String remarks;
	/** 是否删除  -1：已删除  0：正常 */
	private Integer delFlag;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getSort() {
		return sort;
	}

	public void setSort(Double sort) {
		this.sort = sort;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public java.util.Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(java.util.Date createTime) {
		this.createTime = createTime;
	}

	public String getLastUpdateBy() {
		return lastUpdateBy;
	}

	public void setLastUpdateBy(String lastUpdateBy) {
		this.lastUpdateBy = lastUpdateBy;
	}

	public java.util.Date getLastUpdateTime() {
		return lastUpdateTime;
	}

	public void setLastUpdateTime(java.util.Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Integer getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(Integer delFlag) {
		this.delFlag = delFlag;
	}

}
```

#### Dao 代码样例

```
package com.louis.kitty.dao;

import java.util.List;

import com.louis.kitty.model.SysDict;

/**
 * ---------------------------
 * 字典表 (SysDictMapper)         
 * ---------------------------
 * 作者：  kitty-generator
 * 时间：  2018-11-14 17:24:01
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
public interface SysDictMapper {

	/**
	 * 添加字典表
	 * @param record
	 * @return
	 */
    int add(SysDict record);

    /**
     * 删除字典表
     * @param id
     * @return
     */
    int delete(Long id);
    
    /**
     * 修改字典表
     * @param record
     * @return
     */
    int update(SysDict record);
    
    /**
     * 根据主键查询
     * @param id
     * @return
     */    
    SysDict findById(Long id);

    /**
     * 基础分页查询
     * @param record
     * @return
     */    
    List<SysDict> findPage();
    
}
```

#### SqlMap 代码样例

```
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="com.louis.kitty.dao.SysDictMapper">

  <resultMap id="BaseResultMap" type="com.louis.kitty.model.SysDict">
	<id column="id" jdbcType="BIGINT" property="id" />
	<result column="value" jdbcType="VARCHAR" property="value" />
	<result column="label" jdbcType="VARCHAR" property="label" />
	<result column="type" jdbcType="VARCHAR" property="type" />
	<result column="description" jdbcType="VARCHAR" property="description" />
	<result column="sort" jdbcType="DECIMAL" property="sort" />
	<result column="create_by" jdbcType="VARCHAR" property="createBy" />
	<result column="create_time" jdbcType="TIMESTAMP" property="createTime" />
	<result column="last_update_by" jdbcType="VARCHAR" property="lastUpdateBy" />
	<result column="last_update_time" jdbcType="TIMESTAMP" property="lastUpdateTime" />
	<result column="remarks" jdbcType="VARCHAR" property="remarks" />
	<result column="del_flag" jdbcType="TINYINT" property="delFlag" />
  </resultMap>
  
  <insert id="add" parameterType="com.louis.kitty.model.SysDict">
    insert into sys_dict
    <trim prefix="(" suffix=")" suffixOverrides=",">
      <if test="id != null">
        id,
      </if>
      <if test="value != null">
        value,
      </if>
      <if test="label != null">
        label,
      </if>
      <if test="type != null">
        type,
      </if>
      <if test="description != null">
        description,
      </if>
      <if test="sort != null">
        sort,
      </if>
      <if test="createBy != null">
        create_by,
      </if>
      <if test="createTime != null">
        create_time,
      </if>
      <if test="lastUpdateBy != null">
        last_update_by,
      </if>
      <if test="lastUpdateTime != null">
        last_update_time,
      </if>
      <if test="remarks != null">
        remarks,
      </if>
      <if test="delFlag != null">
        del_flag,
      </if>
    </trim>
    <trim prefix="values (" suffix=")" suffixOverrides=",">
      <if test="id != null">
        #{id,jdbcType=BIGINT},
      </if>
      <if test="value != null">
        #{value,jdbcType=VARCHAR},
      </if>
      <if test="label != null">
        #{label,jdbcType=VARCHAR},
      </if>
      <if test="type != null">
        #{type,jdbcType=VARCHAR},
      </if>
      <if test="description != null">
        #{description,jdbcType=VARCHAR},
      </if>
      <if test="sort != null">
        #{sort,jdbcType=DECIMAL},
      </if>
      <if test="createBy != null">
        #{createBy,jdbcType=VARCHAR},
      </if>
      <if test="createTime != null">
        #{createTime,jdbcType=TIMESTAMP},
      </if>
      <if test="lastUpdateBy != null">
        #{lastUpdateBy,jdbcType=VARCHAR},
      </if>
      <if test="lastUpdateTime != null">
        #{lastUpdateTime,jdbcType=TIMESTAMP},
      </if>
      <if test="remarks != null">
        #{remarks,jdbcType=VARCHAR},
      </if>
      <if test="delFlag != null">
        #{delFlag,jdbcType=TINYINT},
      </if>
    </trim>
  </insert>

  <delete id="delete" parameterType="java.lang.Long">
    delete from sys_dict
    where id = #{id,jdbcType=BIGINT}
  </delete>
  
  <update id="update" parameterType="com.louis.kitty.model.SysDict">
    update sys_dict
    <set>
      <if test="id != null">
        id = #{id,jdbcType=BIGINT},
      </if>
      <if test="value != null">
        value = #{value,jdbcType=VARCHAR},
      </if>
      <if test="label != null">
        label = #{label,jdbcType=VARCHAR},
      </if>
      <if test="type != null">
        type = #{type,jdbcType=VARCHAR},
      </if>
      <if test="description != null">
        description = #{description,jdbcType=VARCHAR},
      </if>
      <if test="sort != null">
        sort = #{sort,jdbcType=DECIMAL},
      </if>
      <if test="createBy != null">
        create_by = #{createBy,jdbcType=VARCHAR},
      </if>
      <if test="createTime != null">
        create_time = #{createTime,jdbcType=TIMESTAMP},
      </if>
      <if test="lastUpdateBy != null">
        last_update_by = #{lastUpdateBy,jdbcType=VARCHAR},
      </if>
      <if test="lastUpdateTime != null">
        last_update_time = #{lastUpdateTime,jdbcType=TIMESTAMP},
      </if>
      <if test="remarks != null">
        remarks = #{remarks,jdbcType=VARCHAR},
      </if>
      <if test="delFlag != null">
        del_flag = #{delFlag,jdbcType=TINYINT},
      </if>
    </set>
    where id = #{id,jdbcType=BIGINT}
  </update>

  <select id="findById" parameterType="java.lang.Long" resultMap="BaseResultMap">
    select * from sys_dict
    where id = #{id,jdbcType=BIGINT}
  </select>
  
  <select id="findPage" resultMap="BaseResultMap">
    select * from sys_dict
  </select>
  
</mapper>
```

#### Service 代码样例


```
package com.louis.kitty.service;

import com.louis.kitty.model.SysDict;
import com.louis.kitty.core.service.CurdService;

/**
 * ---------------------------
 * 字典表 (SysDictService)         
 * ---------------------------
 * 作者：  kitty-generator
 * 时间：  2018-11-14 17:24:01
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
public interface SysDictService extends CurdService<SysDict> {

}

```

#### ServiceImpl 代码样例


```
package com.louis.kitty.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.louis.kitty.core.page.MybatisPageHelper;
import com.louis.kitty.core.page.PageRequest;
import com.louis.kitty.core.page.PageResult;

import com.louis.kitty.model.SysDict;
import com.louis.kitty.dao.SysDictMapper;
import com.louis.kitty.service.SysDictService;

/**
 * ---------------------------
 * 字典表 (SysDictServiceImpl)         
 * ---------------------------
 * 作者：  kitty-generator
 * 时间：  2018-11-14 17:24:01
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
@Service
public class SysDictServiceImpl implements SysDictService {

	@Autowired
	private SysDictMapper sysDictMapper;

	@Override
	public int save(SysDict record) {
		if(record.getId() == null || record.getId() == 0) {
			return sysDictMapper.add(record);
		}
		return sysDictMapper.update(record);
	}

	@Override
	public int delete(SysDict record) {
		return sysDictMapper.delete(record.getId());
	}

	@Override
	public int delete(List<SysDict> records) {
		for(SysDict record:records) {
			delete(record);
		}
		return 1;
	}

	@Override
	public SysDict findById(Long id) {
		return sysDictMapper.findById(id);
	}

	@Override
	public PageResult findPage(PageRequest pageRequest) {
		return MybatisPageHelper.findPage(pageRequest, sysDictMapper);
	}
	
}

```

#### Controller 代码样例


```
package com.louis.kitty.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.louis.kitty.core.http.HttpResult;
import com.louis.kitty.core.page.PageRequest;

import com.louis.kitty.model.SysDict;
import com.louis.kitty.service.SysDictService;

/**
 * ---------------------------
 * 字典表 (SysDictController)         
 * ---------------------------
 * 作者：  kitty-generator
 * 时间：  2018-11-14 17:24:01
 * 说明：  我是由代码生成器生生成的
 * ---------------------------
 */
@RestController
@RequestMapping("sysDict")
public class SysDictController {

	@Autowired
	private SysDictService sysDictService;

	/**
	 * 保存字典表
	 * @param record
	 * @return
	 */	
	@PostMapping(value="/save")
	public HttpResult save(@RequestBody SysDict record) {
		return HttpResult.ok(sysDictService.save(record));
	}

    /**
     * 删除字典表
     * @param records
     * @return
     */
	@PostMapping(value="/delete")
	public HttpResult delete(@RequestBody List<SysDict> records) {
		return HttpResult.ok(sysDictService.delete(records));
	}

    /**
     * 基础分页查询
     * @param pageRequest
     * @return
     */    
	@PostMapping(value="/findPage")
	public HttpResult findPage(@RequestBody PageRequest pageRequest) {
		return HttpResult.ok(sysDictService.findPage(pageRequest));
	}
	
    /**
     * 根据主键查询
     * @param id
     * @return
     */ 	
	@GetMapping(value="/findById")
	public HttpResult findById(@RequestParam Long id) {
		return HttpResult.ok(sysDictService.findById(id));
	}
}

```

#### View 代码样例


```
<template>
  <div class="container" style="width:99%;margin-top:-25px;">
	<!--工具栏-->
	<div class="toolbar" style="float:left;padding-top:10px;padding-left:15px;">
		<el-form :inline="true" :model="filters" :size="size">
			<el-form-item>
				<el-input v-model="filters.label" placeholder="名称"></el-input>
			</el-form-item>
			<el-form-item>
				<kt-button :label="$t('action.search')" perms="sys:sysDict:view" type="primary" @click="findPage(null)"/>
			</el-form-item>
			<el-form-item>
				<kt-button :label="$t('action.add')" perms="sys:sysDict:add" type="primary" @click="handleAdd" />
			</el-form-item>
		</el-form>
	</div>
	<!--表格内容栏-->
	<kt-table permsEdit="sys:sysDict:edit" permsDelete="sys:sysDict:delete"
		:data="pageResult" :columns="columns" 
		@findPage="findPage" @handleEdit="handleEdit" @handleDelete="handleDelete">
	</kt-table>
	<!--新增编辑界面-->
	<el-dialog :title="operation?'新增':'编辑'" width="40%" :visible.sync="editDialogVisible" :close-on-click-modal="false">
		<el-form :model="dataForm" label-width="80px" :rules="dataFormRules" ref="dataForm" :size="size">
			<el-form-item label="编号" prop="id"  v-if="dataForm.isPrimaryKey">
				<el-input v-model="dataForm.id" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="数据值" prop="value"  v-if="dataForm.isPrimaryKey">
				<el-input v-model="dataForm.value" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="标签名" prop="label"  v-if="dataForm.isPrimaryKey">
				<el-input v-model="dataForm.label" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="类型" prop="type"  v-if="dataForm.isPrimaryKey">
				<el-input v-model="dataForm.type" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="描述" prop="description"  v-if="dataForm.isPrimaryKey">
				<el-input v-model="dataForm.description" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="排序（升序）" prop="sort"  v-if="dataForm.isPrimaryKey">
				<el-input v-model="dataForm.sort" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="创建人" prop="createBy"  v-if="dataForm.isPrimaryKey">
				<el-input v-model="dataForm.createBy" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="创建时间" prop="createTime"  v-if="dataForm.isPrimaryKey">
				<el-input v-model="dataForm.createTime" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="更新人" prop="lastUpdateBy"  v-if="dataForm.isPrimaryKey">
				<el-input v-model="dataForm.lastUpdateBy" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="更新时间" prop="lastUpdateTime"  v-if="dataForm.isPrimaryKey">
				<el-input v-model="dataForm.lastUpdateTime" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="备注信息" prop="remarks"  v-if="dataForm.isPrimaryKey">
				<el-input v-model="dataForm.remarks" auto-complete="off"></el-input>
			</el-form-item>
			<el-form-item label="是否删除  -1：已删除  0：正常" prop="delFlag"  v-if="dataForm.isPrimaryKey">
				<el-input v-model="dataForm.delFlag" auto-complete="off"></el-input>
			</el-form-item>
		</el-form>
		<div slot="footer" class="dialog-footer">
			<el-button :size="size" @click.native="editDialogVisible = false">{{$t('action.cancel')}}</el-button>
			<el-button :size="size" type="primary" @click.native="submitForm" :loading="editLoading">{{$t('action.submit')}}</el-button>
		</div>
	</el-dialog>
  </div>
</template>

<script>
import KtTable from "@/views/Core/KtTable"
import KtButton from "@/views/Core/KtButton"
import { format } from "@/utils/datetime"
export default {
	components:{
			KtTable,
			KtButton
	},
	data() {
		return {
			size: 'small',
			filters: {
				label: ''
			},
			columns: [
				{prop:"id", label:"编号", minWidth:100},
				{prop:"value", label:"数据值", minWidth:100},
				{prop:"label", label:"标签名", minWidth:100},
				{prop:"type", label:"类型", minWidth:100},
				{prop:"description", label:"描述", minWidth:100},
				{prop:"sort", label:"排序（升序）", minWidth:100},
				{prop:"createBy", label:"创建人", minWidth:100},
				{prop:"createTime", label:"创建时间", minWidth:100},
				{prop:"lastUpdateBy", label:"更新人", minWidth:100},
				{prop:"lastUpdateTime", label:"更新时间", minWidth:100},
				{prop:"remarks", label:"备注信息", minWidth:100},
				{prop:"delFlag", label:"是否删除  -1：已删除  0：正常", minWidth:100},
			],
			pageRequest: { pageNum: 1, pageSize: 8 },
			pageResult: {},

			operation: false, // true:新增, false:编辑
			editDialogVisible: false, // 新增编辑界面是否显示
			editLoading: false,
			dataFormRules: {
				label: [
					{ required: true, message: '请输入名称', trigger: 'blur' }
				]
			},
			// 新增编辑界面数据
			dataForm: {
				id: null,
				value: null,
				label: null,
				type: null,
				description: null,
				sort: null,
				createBy: null,
				createTime: null,
				lastUpdateBy: null,
				lastUpdateTime: null,
				remarks: null,
				delFlag: null,
			}
		}
	},
	methods: {
		// 获取分页数据
		findPage: function (data) {
			if(data !== null) {
				this.pageRequest = data.pageRequest
			}
			this.pageRequest.columnFilters = {label: {name:'label', value:this.filters.label}}
			this.$api.sysDict.findPage(this.pageRequest).then((res) => {
				this.pageResult = res.data
			}).then(data!=null?data.callback:'')
		},
		// 批量删除
		handleDelete: function (data) {
			this.$api.sysDict.batchDelete(data.params).then(data!=null?data.callback:'')
		},
		// 显示新增界面
		handleAdd: function () {
			this.editDialogVisible = true
			this.operation = true
			this.dataForm = {
				id: null,
				value: null,
				label: null,
				type: null,
				description: null,
				sort: null,
				createBy: null,
				createTime: null,
				lastUpdateBy: null,
				lastUpdateTime: null,
				remarks: null,
				delFlag: null,
			}
		},
		// 显示编辑界面
		handleEdit: function (params) {
			this.editDialogVisible = true
			this.operation = false
			this.dataForm = Object.assign({}, params.row)
		},
		// 编辑
		submitForm: function () {
			this.$refs.dataForm.validate((valid) => {
				if (valid) {
					this.$confirm('确认提交吗？', '提示', {}).then(() => {
						this.editLoading = true
						let params = Object.assign({}, this.dataForm)
						this.$api.sysDict.save(params).then((res) => {
							if(res.code == 200) {
								this.$message({ message: '操作成功', type: 'success' })
							} else {
								this.$message({message: '操作失败, ' + res.msg, type: 'error'})
							}
							this.editLoading = false
							this.$refs['dataForm'].resetFields()
							this.editDialogVisible = false
							this.findPage(null)
						})
					})
				}
			})
		},
		// 时间格式化
      	dateFormat: function (row, column, cellValue, index){
          	return format(row[column.property])
      	}
	},
	mounted() {
	}
}
</script>

<style scoped>

</style>
```


#### 参与贡献

1. Fork 本项目
2. 新建 Feat_xxx 分支
3. 提交代码
4. 新建 Pull Request


#### 码云特技

1. 使用 Readme\_XXX.md 来支持不同的语言，例如 Readme\_en.md, Readme\_zh.md
2. 码云官方博客 [blog.gitee.com](https://blog.gitee.com)
3. 你可以 [https://gitee.com/explore](https://gitee.com/explore) 这个地址来了解码云上的优秀开源项目
4. [GVP](https://gitee.com/gvp) 全称是码云最有价值开源项目，是码云综合评定出的优秀开源项目
5. 码云官方提供的使用手册 [https://gitee.com/help](https://gitee.com/help)
6. 码云封面人物是一档用来展示码云会员风采的栏目 [https://gitee.com/gitee-stars/](https://gitee.com/gitee-stars/)