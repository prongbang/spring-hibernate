# Spring Security 4 + Hibernate ORM 5

<h2>Role: Admin</h2>
<ul>
<li>user: admin</li>
<li>pass: password</li>
</ul>

<h2>Role: DBA</h2>
<ul>
<li>user: dba</li>
<li>pass: password</li>
</ul>

<h2>Role: User</h2>
<ul>
<li>user: user</li>
<li>pass: password</li>
</ul>

<h2>Database: hibernate</h2>
<h3>SQL SERVER</h3>
```sql
USE [hibernate]
GO
/****** Object:  Table [dbo].[Address] ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Address](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[person_id] [int] NOT NULL,
	[address_name] [varchar](200) NOT NULL,
 CONSTRAINT [PK_Address] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Person] ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Person](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[name] [varchar](50) NOT NULL,
	[country] [varchar](50) NOT NULL,
 CONSTRAINT [PK_Person] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
SET IDENTITY_INSERT [dbo].[Address] ON 

INSERT [dbo].[Address] ([id], [person_id], [address_name]) VALUES (2, 1, N'Bangkok 10240')
INSERT [dbo].[Address] ([id], [person_id], [address_name]) VALUES (4, 1, N'Nontaburi 23021')
SET IDENTITY_INSERT [dbo].[Address] OFF
SET IDENTITY_INSERT [dbo].[Person] ON 

INSERT [dbo].[Person] ([id], [name], [country]) VALUES (1, N'prongbang', N'Thailand')
SET IDENTITY_INSERT [dbo].[Person] OFF
ALTER TABLE [dbo].[Address]  WITH CHECK ADD  CONSTRAINT [FK_Address_Address] FOREIGN KEY([person_id])
REFERENCES [dbo].[Person] ([id])
GO
ALTER TABLE [dbo].[Address] CHECK CONSTRAINT [FK_Address_Address]
GO

```
