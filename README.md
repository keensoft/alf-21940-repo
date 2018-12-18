
Alfresco Patch to Solr6 multiple locale search
================================================

Described at issue [ALF-21940](https://issues.alfresco.com/jira/browse/ALF-21940)

**DISCLAIMER**

SOLR 6 can be configured to work as SOLR 4 was working in previous Alfresco versions by uncommenting **alfresco.cross.locale.datatype.N** properties in `/opt/solr6/solrhome/conf/shared.properties`.

```
alfresco.cross.locale.datatype.0={http://www.alfresco.org/model/dictionary/1.0}text
alfresco.cross.locale.datatype.1={http://www.alfresco.org/model/dictionary/1.0}content
alfresco.cross.locale.datatype.2={http://www.alfresco.org/model/dictionary/1.0}mltext
```

You can perform this operation and there is **no** need to install this addon. 

Once this `shared.properties` file has been modified is required to rebuild SOLR indexes. After that, every searching will be performed in Alfresco with cross-language support and you'll get the same behaviour that is provided by this patch.

**Description**

Alfresco when store a new document save a property called `sys:locale`, this property is based in the browser selected language. When another user with the browser in a different language go search for the document by the name can not found it, because the `locale` value is different. This problem is only detected in Solr6.

This patch, remove the parameter locale in Solr6 http requests.

**License**
The plugin is licensed under the [LGPL v3.0](http://www.gnu.org/licenses/lgpl-3.0.html). 

**State**
Current patch release is 1.1.0

**Compatibility** 
The current version has been developed using Alfresco 201702 and Alfresco SDK 3.0.1

***Original Alfresco resources have been overwritten***

Downloading the ready-to-deploy-plugin
--------------------------------------
The binary distribution is made of one JAR file to be deployed in Alfresco as a repo module:

* [repo JAR](https://github.com/keensoft/alf-21940-repo/releases/download/1.1.0/patch-alf-21940-repo-1.1.0.jar)

You can install it by copying JAR file to `$ALFRESCO_HOME/modules/platform` and re-starting Alfresco.


Building the artifacts
----------------------
You can build the artifacts from source code using maven
```$ mvn clean package```

