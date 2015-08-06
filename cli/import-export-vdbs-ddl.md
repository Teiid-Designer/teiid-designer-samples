### Import and Export VDBs and DDL

These samples show how to use the VDB Builder cli to import and export VDBs and DDL interactively.  Use this sample as a starting point for working with your own VDBs and DDL.

Remember, you can use __tab completion__ to see the available commands and sub-command options, or use __help__ to see command details.


### Requirements

* Install VDB Builder cli - refer to the [Installation Instructions](install-cli.md) for details


### Import and Export VDBs

The sample session below shows how to import and export a dynamic VDB.  The session shows import of __PartsVDB-vdb.xml__ , set property to change the VDB version, then export of the VDB into a different dynamic VDB file.

![Import-Export VDB Session](img/cli-import-export-VDB.png)

---
```
import vdb <vdbFile>
``` 
import VDB from "vdbFile" into the workspace

```
export vdb PartsVDB <vdbFile>
```
export PartsVDB to the specified file "vdbFile"

---

### Import and Export DDL

The sample session below shows how to import and export DDL.  The session shows creation of a VDB with Model1, then import of __Teiid-MySQLAccounts.ddl__ to create the Model1 content, then export of the model contents into a different DDL file.

![Import-Export DDL Session](img/cli-import-export-DDL.png)

---
```
import ddl <ddlFile> [parentObject]
``` 
import DDL from "ddlFile" into parentObject

```
export ddl Model1 <ddlFile>
```
export Model1 content to the specified file "ddlFile"

---


