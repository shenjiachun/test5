#!/bin/bash
@echo off
echo 使用此脚本必须具备以下条件:
echo 1.Shell 环境, 执行命令时请使用bash接收器
echo 2.安装了jdk 1.8+ , 并且配置了环境变量
echo 3.安装了git , 能够在DOS窗口执行git clone命令
echo 4.拥有脚手架工程的Clone权限 ：git@github.com:king-2015/xiaoya-project-backend.git
echo ...... ...... ......
echo ...... ...... ......
read -p "我已满足上述条件,继续?(Y/N):" continue_yn
if  [ $continue_yn = "Y" ]
then 
  echo Continue ..
else
  exit
fi


# 检查文件是否存在,防止误删
if test -e ./xiaoya-project-backend
then 
	echo The dir xiaoya-project-backend  already exists , please delete it ,and then try again.	
	exit
fi


# 从git检出模板项目
echo Cloning project from github : git@github.com:king-2015/xiaoya-project-backend.git
if test ! -e ./xiaoya-project-backend 
then
	git clone -b dev git@github.com:king-2015/xiaoya-project-backend.git
fi

# 检查是否检出项目
if test ! -e ./xiaoya-project-backend 
then
	echo Cloning project from github failed.
	exit
fi

# 脚手架项目所在目录
cd  xiaoya-project-backend


# 删除git文件，防止误提交
echo Deleting other projects .
# .git 为只读隐藏文件
if test -e ./.git 
then 
	rm -fr .git
fi

src_project_name="xiaoya-project-scaffold"

# 删除其他项目文件
for f in `ls`
do 
	if [ $f = $src_project_name ]
	then
		continue
	fi
	rm -fr $f
done
echo Done .


base_projectName=""

# 更改项目名称
read -p "Project name : " projectName
base_projectName=$projectName
echo Rename project "xiaoya-project-scaffold" to $projectName ..
mv xiaoya-project-scaffold $projectName
cd $projectName

parent_group_id=""
parent_artifact_id=""

echo -----修改parent的groupId和ArtifactId-------
# 修改pom
read -p "Maven Parent Group Id : " groupId
parent_group_id=$groupId
java -jar ../../Replace.jar pom.xml com.xiaoya.scaffold $groupId

read -p "Maven Parent Artifact Id : " artifactId
parent_artifact_id=$artifactId
java -jar ../../Replace.jar pom.xml xiaoya-project-scaffold $artifactId

api_artifact_id=""

echo -----修改api的groupId和ArtifactId-------
cd api
# 修改pom
#read -p "Maven api Group Id : " groupId
java -jar ../../../Replace.jar pom.xml com.xiaoya.scaffold $parent_group_id

read -p "Maven api Artifact Id : " artifactId
api_artifact_id=$artifactId
java -jar ../../../Replace.jar pom.xml xiaoya-project-scaffold-api $artifactId
java -jar ../../../Replace.jar pom.xml xiaoya-project-scaffold $parent_artifact_id

echo -----修改consumer的groupId和ArtifactId-------
cd ../consumer
# 修改pom
#read -p "Maven consumer Group Id : " groupId
java -jar ../../../Replace.jar pom.xml com.xiaoya.scaffold $parent_group_id

java -jar ../../../Replace.jar pom.xml xiaoya-project-scaffold-api $api_artifact_id
read -p "Maven consumer Artifact Id : " artifactId
java -jar ../../../Replace.jar pom.xml xiaoya-project-scaffold-api $artifactId
java -jar ../../../Replace.jar pom.xml xiaoya-project-scaffold $parent_artifact_id

echo -----修改provider的groupId和ArtifactId-------
cd ../provider
# 修改pom
#read -p "Maven provider Group Id : " groupId
java -jar ../../../Replace.jar pom.xml com.xiaoya.scaffold $parent_group_id

java -jar ../../../Replace.jar pom.xml xiaoya-project-scaffold-api $api_artifact_id
read -p "Maven provider Artifact Id : " artifactId
java -jar ../../../Replace.jar pom.xml xiaoya-project-scaffold-api $artifactId
java -jar ../../../Replace.jar pom.xml xiaoya-project-scaffold $parent_artifact_id


cd ..

base_pagekage=""

echo -----替换api模块下文件中包相关的内容-------
# 生成包
cd api/src/main/java/com/xiaoya
read -p "Base packege: com.xiaoya." basePagekage
base_pagekage=$basePagekage

# 循环生成子包
for pk in ${basePagekage//./ }
do 
	mkdir ${pk}
	mv scaffold ${pk}/scaffold
	cd ${pk}
done

mv scaffold/* .
rm -rf scaffold

# 替换文件中包相关的内容
echo -----替换文件内容-------
# 返回src所在目录
until test -e src
do 
	cd ..
done

java -jar ../../../Replace.jar src com.xiaoya.scaffold com.xiaoya.$basePagekage
java -jar ../../../Replace.jar src xiaoya-project-scaffold $base_projectName
java -jar ../../../Replace.jar src backend.scaffold.xiaoya-project-scaffold-consumer backend.$base_pagekage.$base_projectName-api

cd ..

echo -----替换consumer模块下文件中包相关的内容-------
# 生成包
cd consumer/src/main/java/com/xiaoya
#read -p "Base packege: com.xiaoya." basePagekage

# 循环生成子包
for pk in ${base_pagekage//./ }
do 
	mkdir ${pk}
	mv scaffold ${pk}/scaffold
	cd ${pk}
done

mv scaffold/* .
rm -rf scaffold

# 替换文件中包相关的内容
echo -----替换文件内容-------
# 返回src所在目录
until test -e src
do 
	cd ..
done

java -jar ../../../Replace.jar src com.xiaoya.scaffold com.xiaoya.$base_pagekage
java -jar ../../../Replace.jar src xiaoya-project-scaffold $base_projectName
java -jar ../../../Replace.jar src backend.scaffold.xiaoya-project-scaffold-consumer backend.$base_pagekage.$base_projectName-consumer

cd ..

echo -----替换provider模块下文件中包相关的内容-------
# 生成包
cd provider/src/main/java/com/xiaoya
#read -p "Base packege: com.xiaoya." basePagekage

# 循环生成子包
for pk in ${base_pagekage//./ }
do 
	mkdir ${pk}
	mv scaffold ${pk}/scaffold
	cd ${pk}
done

mv scaffold/* .
rm -rf scaffold

# 替换文件中包相关的内容
echo -----替换文件内容-------
# 返回src所在目录
until test -e src
do 
	cd ..
done

java -jar ../../../Replace.jar src com.xiaoya.scaffold com.xiaoya.$base_pagekage
java -jar ../../../Replace.jar src xiaoya-project-scaffold $base_projectName
java -jar ../../../Replace.jar src backend.scaffold.xiaoya-project-scaffold-consumer backend.$base_pagekage.$base_projectName-provider











