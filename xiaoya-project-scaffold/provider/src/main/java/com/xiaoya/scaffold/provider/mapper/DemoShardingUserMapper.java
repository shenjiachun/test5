package com.xiaoya.scaffold.provider.mapper;

import com.xiaoya.scaffold.provider.bean.DemoShardingUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


//@Mapper
public interface DemoShardingUserMapper {
	
	Long addUser(DemoShardingUser demoShardingUser);
	
	List<DemoShardingUser> list();
	
	DemoShardingUser findById(Long id);
	
	DemoShardingUser findByName(String name);
}
