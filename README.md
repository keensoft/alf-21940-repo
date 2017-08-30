
Alfresco Patch to 
================================================

Described at issue ![ALF-21940](https://issues.alfresco.com/jira/browse/ALF-21940?jql=project%20%3D%20ALF)

Alfresco when store a new document save a property called `sys:locale`, this property is based in the language of the browser. When another user with the browser in a different language go search the document by the name can not found it, because the `locale` value is different.


This patch, remove the parameter locale in Solr6 http requests.

**License**
The plugin is licensed under the [LGPL v3.0](http://www.gnu.org/licenses/lgpl-3.0.html). 

**State**
Current patch release is 1.0.0

**Compatibility** 
The current version has been developed using Alfresco 201702 and Alfresco SDK 3.0.1

***Original Alfresco resources have been overwritten***

Downloading the ready-to-deploy-plugin
--------------------------------------
The binary distribution is made of one JAR file to be deployed in Alfresco as a repo module:

* [repo JAR]()

You can install it by copying JAR file to `$ALFRESCO_HOME/modules/platform` and re-starting Alfresco.


Building the artifacts
----------------------
You can build the artifacts from source code using maven
```$ mvn clean package```

