<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd" >

<mapper namespace="com.taotaotech.dao.UserMapper" >
    <resultMap id="BaseResultMap" type="User" >
        <id column="id" jdbcType="INTEGER" property="id" />
        <result column="code" jdbcType="VARCHAR" property="code" />
        <result column="username" jdbcType="VARCHAR" property="username" />
        <result column="password" jdbcType="VARCHAR" property="password" />
        <result column="role" jdbcType="TINYINT" property="role" />
        <result column="create_date" jdbcType="TIMESTAMP" property="createDate" />
        <result column="update_date" jdbcType="TIMESTAMP" property="updateDate" />
        <result column="del_flag" jdbcType="BIT" property="delFlag" />
    </resultMap>
    <sql id="Base_Column_List" >
        id, code, username, password, role, create_date, update_date, del_flag
    </sql>

    <!-- 根据主键查询 -->
    <select id="get" resultMap="BaseResultMap" parameterType="User">
        SELECT
        <include refid="Base_Column_List" />
        FROM sys_user
        where id = #{id}
    </select>

    <!-- 分页查询 -->
    <select id="findList" parameterType="User" resultType="User">
        select
        <include refid="Base_Column_List" />
        from sys_user t
        <where>
            del_flag = #{DEL_FLAG_NORMAL}
            <if test="code != null and code != ''">
                AND code like '%${code}%'
            </if>
            <if test="username != null and username != ''">
                AND username like '%${username}%'
            </if>
            <if test="role != null and role != ''">
                AND role = #{role}
            </if>
            <if test="create_date != null and create_date != ''">
                AND create_date = #{createDate}
            </if>
            <if test="update_date != null and update_date != ''">
                AND update_date = #{updateDate}
            </if>
        </where>
        <choose>
            <when test="page !=null and page.orderBy != null and page.orderBy != ''">
                ORDER BY ${page.orderBy}
            </when>
            <otherwise>
                ORDER BY t.id DESC
            </otherwise>
        </choose>
    </select>

    <!-- 根据 Entity 查询全部数据 -->
    <select id="findAllList" resultMap="BaseResultMap" >
        SELECT
        <include refid="Base_Column_List" />
        FROM sys_user
        WHERE del_flag = #{DEL_FLAG_NORMAL}
        ORDER BY create_date DESC
    </select>

    <!-- 插入逻辑 -->
    <insert id="insert" parameterType="User" >
        INSERT INTO sys_user
        (<include refid="Base_Column_List" />)
        VALUES (
        #{id},
        #{code},
        #{username},
        #{password},
        #{role},
        #{createDate},
        #{updateDate},
        #{delFlag}
        )
    </insert>

    <!-- 更新逻辑 -->
    <update id="update" parameterType="User" >
        UPDATE sys_user SET
        code = #{code},
        username = #{username},
        password = #{password},
        role = #{role},
        update_date = #{updateDate}
        WHERE id = #{id}
    </update>

    <!-- 逻辑删除用户 -->
    <update id="delete">
        UPDATE sys_user SET
        del_flag = #{DEL_FLAG_DELETE}
        WHERE id = #{id}
    </update>

</mapper>