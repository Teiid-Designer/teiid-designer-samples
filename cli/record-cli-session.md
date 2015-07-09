# Overview

This article shows how you can use the VDB Builder cli to record session commands, then play them back later.


# Requirements

* VDB Builder cli installed - refer to [installation instructions] (install-cli.md) for details


# Preparing the Data

The data sources to be used consist of the following:

* [Teiid-MySQLAccounts.ddl](../metadata/Teiid-MySQLAccounts.ddl)

The files should be copied to a location where both are accessible by the Teiid installation, eg. /usr/share/teiid.


# Import Procedure 

* On the Import Wizard select **DDL File >> Source or View Model** and click **Next>**

![Import Wizard](img/importer-wizard.png)

* In **Provide DDL source** page, select the DDL file, Set the Model folder location, enter or select valid model name, set Model type (Source Model or View Model), set desired options and click **NEXT >**

![Source View](img/importer-ddl-source-view.png)

* In **Select the Differences to Apply** page, a difference report is presented for viewing or deselecting individual relational entities. Click **Finish** to complete.

![Objects to create](img/importer-ddl-object-to-create.png)

> Note, **Modeling -> Set Connection Profile** is necessary for Preview Data

# Test
