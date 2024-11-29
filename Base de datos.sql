USE [master]
GO
/****** Object:  Database [ProyectoVeterinaria]    Script Date: 28/11/2024 22:17:37 ******/
CREATE DATABASE [ProyectoVeterinaria]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'Proyecto Veterinaria', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL16.MSSQLSERVER\MSSQL\DATA\Proyecto Veterinaria.mdf' , SIZE = 73728KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'Proyecto Veterinaria_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL16.MSSQLSERVER\MSSQL\DATA\Proyecto Veterinaria_log.ldf' , SIZE = 73728KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT, LEDGER = OFF
GO
ALTER DATABASE [ProyectoVeterinaria] SET COMPATIBILITY_LEVEL = 160
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [ProyectoVeterinaria].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [ProyectoVeterinaria] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [ProyectoVeterinaria] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [ProyectoVeterinaria] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [ProyectoVeterinaria] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [ProyectoVeterinaria] SET ARITHABORT OFF 
GO
ALTER DATABASE [ProyectoVeterinaria] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [ProyectoVeterinaria] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [ProyectoVeterinaria] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [ProyectoVeterinaria] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [ProyectoVeterinaria] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [ProyectoVeterinaria] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [ProyectoVeterinaria] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [ProyectoVeterinaria] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [ProyectoVeterinaria] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [ProyectoVeterinaria] SET  DISABLE_BROKER 
GO
ALTER DATABASE [ProyectoVeterinaria] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [ProyectoVeterinaria] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [ProyectoVeterinaria] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [ProyectoVeterinaria] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [ProyectoVeterinaria] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [ProyectoVeterinaria] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [ProyectoVeterinaria] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [ProyectoVeterinaria] SET RECOVERY FULL 
GO
ALTER DATABASE [ProyectoVeterinaria] SET  MULTI_USER 
GO
ALTER DATABASE [ProyectoVeterinaria] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [ProyectoVeterinaria] SET DB_CHAINING OFF 
GO
ALTER DATABASE [ProyectoVeterinaria] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [ProyectoVeterinaria] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [ProyectoVeterinaria] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [ProyectoVeterinaria] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
EXEC sys.sp_db_vardecimal_storage_format N'ProyectoVeterinaria', N'ON'
GO
ALTER DATABASE [ProyectoVeterinaria] SET QUERY_STORE = ON
GO
ALTER DATABASE [ProyectoVeterinaria] SET QUERY_STORE (OPERATION_MODE = READ_WRITE, CLEANUP_POLICY = (STALE_QUERY_THRESHOLD_DAYS = 30), DATA_FLUSH_INTERVAL_SECONDS = 900, INTERVAL_LENGTH_MINUTES = 60, MAX_STORAGE_SIZE_MB = 1000, QUERY_CAPTURE_MODE = AUTO, SIZE_BASED_CLEANUP_MODE = AUTO, MAX_PLANS_PER_QUERY = 200, WAIT_STATS_CAPTURE_MODE = ON)
GO
USE [ProyectoVeterinaria]
GO
/****** Object:  User [UserProject]    Script Date: 28/11/2024 22:17:37 ******/
CREATE USER [UserProject] WITHOUT LOGIN WITH DEFAULT_SCHEMA=[db_accessadmin]
GO
/****** Object:  Table [dbo].[Actitud]    Script Date: 28/11/2024 22:17:37 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Actitud](
	[id_actitud] [nchar](1) NOT NULL,
	[descripcion] [nchar](15) NOT NULL,
 CONSTRAINT [PK_Actitud] PRIMARY KEY CLUSTERED 
(
	[id_actitud] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Cita]    Script Date: 28/11/2024 22:17:37 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Cita](
	[id_cita] [int] IDENTITY(1,1) NOT NULL,
	[id_Paciente] [int] NOT NULL,
	[diagnostico] [ntext] NOT NULL,
	[indicaciones] [ntext] NOT NULL,
	[fechaCita] [datetime] NOT NULL,
	[frecuenciaCardiaca] [int] NOT NULL,
	[frecuenciaRespiratoria] [int] NOT NULL,
	[pulso] [int] NOT NULL,
	[temperatura] [int] NOT NULL,
	[id_condicion] [nchar](1) NOT NULL,
	[fechaProximaCita] [datetime] NULL,
 CONSTRAINT [PK_Cita_1] PRIMARY KEY CLUSTERED 
(
	[id_cita] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Cita_Actitud]    Script Date: 28/11/2024 22:17:37 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Cita_Actitud](
	[id_cita] [int] NOT NULL,
	[id_actitud] [nchar](1) NOT NULL,
 CONSTRAINT [PK_Cita_Actitud] PRIMARY KEY CLUSTERED 
(
	[id_cita] ASC,
	[id_actitud] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Cita_Evaluacion]    Script Date: 28/11/2024 22:17:37 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Cita_Evaluacion](
	[id_cita] [int] NOT NULL,
	[id_evaluacion] [int] NOT NULL,
 CONSTRAINT [PK_Cita_Evaluacion_1] PRIMARY KEY CLUSTERED 
(
	[id_cita] ASC,
	[id_evaluacion] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Cita_motivo]    Script Date: 28/11/2024 22:17:37 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Cita_motivo](
	[id_Cita_Motivo] [int] IDENTITY(1,1) NOT NULL,
	[id_motivo] [int] NOT NULL,
	[id_cita] [int] NOT NULL,
	[id_vacuna] [int] NULL,
	[precio] [float] NOT NULL,
	[aplica_examen] [bit] NOT NULL,
 CONSTRAINT [PK_Cita_motivo_1] PRIMARY KEY CLUSTERED 
(
	[id_Cita_Motivo] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Cita_PruebaLaboratorio]    Script Date: 28/11/2024 22:17:37 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Cita_PruebaLaboratorio](
	[id_cita] [int] NOT NULL,
	[id_pruebaLaboratorio] [int] NOT NULL,
	[id_subCategoria] [int] NOT NULL,
 CONSTRAINT [PK_Cita_PruebaLaboratorio_1] PRIMARY KEY CLUSTERED 
(
	[id_cita] ASC,
	[id_pruebaLaboratorio] ASC,
	[id_subCategoria] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Condicion]    Script Date: 28/11/2024 22:17:37 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Condicion](
	[id_condicion] [nchar](1) NOT NULL,
	[descripcion] [nchar](15) NOT NULL,
 CONSTRAINT [PK_Estado] PRIMARY KEY CLUSTERED 
(
	[id_condicion] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Dueño]    Script Date: 28/11/2024 22:17:37 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Dueño](
	[cedula] [nchar](9) NOT NULL,
	[nombre] [ntext] NOT NULL,
	[direccion] [nchar](100) NOT NULL,
	[numero_telefono] [nchar](8) NOT NULL,
 CONSTRAINT [PK_Dueño] PRIMARY KEY CLUSTERED 
(
	[cedula] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Especie]    Script Date: 28/11/2024 22:17:37 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Especie](
	[id_especie] [int] IDENTITY(1,1) NOT NULL,
	[nombre_especie] [nchar](30) NOT NULL,
 CONSTRAINT [PK_Especies] PRIMARY KEY CLUSTERED 
(
	[id_especie] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Estado]    Script Date: 28/11/2024 22:17:37 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Estado](
	[id_estado] [nchar](1) NOT NULL,
	[estado] [nchar](10) NOT NULL,
 CONSTRAINT [PK_Estado_1] PRIMARY KEY CLUSTERED 
(
	[id_estado] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Evaluacion]    Script Date: 28/11/2024 22:17:37 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Evaluacion](
	[id_evaluacion] [int] IDENTITY(1,1) NOT NULL,
	[id_tipo_evaluacion] [nchar](2) NOT NULL,
	[id_estado] [nchar](1) NOT NULL,
 CONSTRAINT [PK_Evaluacion] PRIMARY KEY CLUSTERED 
(
	[id_evaluacion] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Motivo]    Script Date: 28/11/2024 22:17:37 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Motivo](
	[id_motivo] [int] IDENTITY(1,1) NOT NULL,
	[descripcion] [ntext] NOT NULL,
	[precio] [float] NULL,
	[aplica_examen] [bit] NOT NULL,
	[tiene_vacuna] [bit] NOT NULL,
 CONSTRAINT [PK_Motivo] PRIMARY KEY CLUSTERED 
(
	[id_motivo] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Paciente]    Script Date: 28/11/2024 22:17:37 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Paciente](
	[id_paciente] [int] IDENTITY(1,1) NOT NULL,
	[cedula_dueño] [nchar](9) NOT NULL,
	[nombre] [ntext] NOT NULL,
	[sexo] [nchar](10) NOT NULL,
	[edad] [int] NOT NULL,
	[id_especie] [int] NOT NULL,
	[id_raza] [int] NOT NULL,
 CONSTRAINT [PK_Paciente_1] PRIMARY KEY CLUSTERED 
(
	[id_paciente] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[PruebaLaboratorio]    Script Date: 28/11/2024 22:17:37 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PruebaLaboratorio](
	[id_prueba] [int] NOT NULL,
	[precio] [float] NULL,
	[nombre] [ntext] NOT NULL,
 CONSTRAINT [PK_PruebaLaboratorio] PRIMARY KEY CLUSTERED 
(
	[id_prueba] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Raza]    Script Date: 28/11/2024 22:17:37 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Raza](
	[id_raza] [int] IDENTITY(1,1) NOT NULL,
	[id_especie] [int] NOT NULL,
	[nombre_raza] [nchar](30) NOT NULL,
 CONSTRAINT [PK_Raza_1] PRIMARY KEY CLUSTERED 
(
	[id_raza] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[SubCategoriaPrueba]    Script Date: 28/11/2024 22:17:37 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[SubCategoriaPrueba](
	[id_subCategoria] [int] IDENTITY(1,1) NOT NULL,
	[id_prueba] [int] NOT NULL,
	[nombre] [ntext] NOT NULL,
	[precio] [float] NOT NULL,
 CONSTRAINT [PK_SubCategoriaPrueba_1] PRIMARY KEY CLUSTERED 
(
	[id_subCategoria] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Tipo_evaluacion]    Script Date: 28/11/2024 22:17:37 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Tipo_evaluacion](
	[id_tipo_evaluacion] [nchar](2) NOT NULL,
	[tipo_evaluacion] [nchar](20) NOT NULL,
 CONSTRAINT [PK_Tipo_evaluacion] PRIMARY KEY CLUSTERED 
(
	[id_tipo_evaluacion] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Usuario]    Script Date: 28/11/2024 22:17:37 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Usuario](
	[id_usuario] [int] IDENTITY(1,1) NOT NULL,
	[nombre_usuario] [ntext] NOT NULL,
	[contraseña] [ntext] NOT NULL,
 CONSTRAINT [PK_Usuario] PRIMARY KEY CLUSTERED 
(
	[id_usuario] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Vacuna]    Script Date: 28/11/2024 22:17:37 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Vacuna](
	[id_vacuna] [int] IDENTITY(1,1) NOT NULL,
	[id_especie] [int] NOT NULL,
	[precio] [float] NOT NULL,
	[nombre] [nchar](15) NOT NULL,
 CONSTRAINT [PK_Vacuna_1] PRIMARY KEY CLUSTERED 
(
	[id_vacuna] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[Actitud] ([id_actitud], [descripcion]) VALUES (N'1', N'EXCITADO       ')
INSERT [dbo].[Actitud] ([id_actitud], [descripcion]) VALUES (N'2', N'DEPRIMIDO      ')
INSERT [dbo].[Actitud] ([id_actitud], [descripcion]) VALUES (N'3', N'POSTRADO       ')
GO
SET IDENTITY_INSERT [dbo].[Cita] ON 

INSERT [dbo].[Cita] ([id_cita], [id_Paciente], [diagnostico], [indicaciones], [fechaCita], [frecuenciaCardiaca], [frecuenciaRespiratoria], [pulso], [temperatura], [id_condicion], [fechaProximaCita]) VALUES (1, 10, N'Está todo en orden', N'No hay', CAST(N'2024-11-20T18:30:00.000' AS DateTime), 110, 25, 115, 36, N'2', NULL)
INSERT [dbo].[Cita] ([id_cita], [id_Paciente], [diagnostico], [indicaciones], [fechaCita], [frecuenciaCardiaca], [frecuenciaRespiratoria], [pulso], [temperatura], [id_condicion], [fechaProximaCita]) VALUES (2, 12, N'', N'', CAST(N'2024-11-30T10:38:00.000' AS DateTime), 0, 0, 0, 0, N'1', NULL)
INSERT [dbo].[Cita] ([id_cita], [id_Paciente], [diagnostico], [indicaciones], [fechaCita], [frecuenciaCardiaca], [frecuenciaRespiratoria], [pulso], [temperatura], [id_condicion], [fechaProximaCita]) VALUES (4, 16, N'En general está bien', N'Hacer mas chequeos', CAST(N'2024-11-22T10:00:00.000' AS DateTime), 115, 15, 120, 40, N'1', NULL)
INSERT [dbo].[Cita] ([id_cita], [id_Paciente], [diagnostico], [indicaciones], [fechaCita], [frecuenciaCardiaca], [frecuenciaRespiratoria], [pulso], [temperatura], [id_condicion], [fechaProximaCita]) VALUES (5, 4, N'Necesita ganar peso', N'Alimentar más al paciente', CAST(N'2024-11-22T14:24:41.627' AS DateTime), 115, 15, 115, 35, N'1', NULL)
INSERT [dbo].[Cita] ([id_cita], [id_Paciente], [diagnostico], [indicaciones], [fechaCita], [frecuenciaCardiaca], [frecuenciaRespiratoria], [pulso], [temperatura], [id_condicion], [fechaProximaCita]) VALUES (6, 17, N'', N'', CAST(N'2024-11-22T14:32:15.333' AS DateTime), 105, 13, 110, 36, N'2', NULL)
INSERT [dbo].[Cita] ([id_cita], [id_Paciente], [diagnostico], [indicaciones], [fechaCita], [frecuenciaCardiaca], [frecuenciaRespiratoria], [pulso], [temperatura], [id_condicion], [fechaProximaCita]) VALUES (7, 17, N'', N'', CAST(N'2024-11-22T14:32:15.333' AS DateTime), 105, 13, 110, 36, N'2', NULL)
INSERT [dbo].[Cita] ([id_cita], [id_Paciente], [diagnostico], [indicaciones], [fechaCita], [frecuenciaCardiaca], [frecuenciaRespiratoria], [pulso], [temperatura], [id_condicion], [fechaProximaCita]) VALUES (12, 18, N'', N'', CAST(N'2024-11-23T17:08:00.000' AS DateTime), 100, 10, 100, 35, N'3', NULL)
INSERT [dbo].[Cita] ([id_cita], [id_Paciente], [diagnostico], [indicaciones], [fechaCita], [frecuenciaCardiaca], [frecuenciaRespiratoria], [pulso], [temperatura], [id_condicion], [fechaProximaCita]) VALUES (13, 18, N'', N'', CAST(N'2024-11-25T17:25:00.000' AS DateTime), 109, 12, 105, 38, N'1', NULL)
INSERT [dbo].[Cita] ([id_cita], [id_Paciente], [diagnostico], [indicaciones], [fechaCita], [frecuenciaCardiaca], [frecuenciaRespiratoria], [pulso], [temperatura], [id_condicion], [fechaProximaCita]) VALUES (14, 18, N'', N'', CAST(N'2024-11-22T18:59:32.523' AS DateTime), 100, 10, 100, 35, N'2', NULL)
INSERT [dbo].[Cita] ([id_cita], [id_Paciente], [diagnostico], [indicaciones], [fechaCita], [frecuenciaCardiaca], [frecuenciaRespiratoria], [pulso], [temperatura], [id_condicion], [fechaProximaCita]) VALUES (15, 3, N'', N'', CAST(N'2024-11-25T19:00:00.000' AS DateTime), 100, 10, 100, 35, N'3', CAST(N'2025-01-24T19:00:00.000' AS DateTime))
INSERT [dbo].[Cita] ([id_cita], [id_Paciente], [diagnostico], [indicaciones], [fechaCita], [frecuenciaCardiaca], [frecuenciaRespiratoria], [pulso], [temperatura], [id_condicion], [fechaProximaCita]) VALUES (16, 19, N'', N'', CAST(N'2024-11-26T19:15:00.000' AS DateTime), 100, 10, 100, 35, N'2', CAST(N'2024-12-26T19:15:00.000' AS DateTime))
INSERT [dbo].[Cita] ([id_cita], [id_Paciente], [diagnostico], [indicaciones], [fechaCita], [frecuenciaCardiaca], [frecuenciaRespiratoria], [pulso], [temperatura], [id_condicion], [fechaProximaCita]) VALUES (19, 2, N'', N'', CAST(N'2024-11-25T19:01:00.000' AS DateTime), 100, 10, 100, 35, N'1', CAST(N'2024-12-25T19:01:00.000' AS DateTime))
INSERT [dbo].[Cita] ([id_cita], [id_Paciente], [diagnostico], [indicaciones], [fechaCita], [frecuenciaCardiaca], [frecuenciaRespiratoria], [pulso], [temperatura], [id_condicion], [fechaProximaCita]) VALUES (20, 5, N'', N'', CAST(N'2024-11-25T20:30:00.000' AS DateTime), 100, 10, 100, 35, N'2', CAST(N'2025-01-24T20:30:00.000' AS DateTime))
INSERT [dbo].[Cita] ([id_cita], [id_Paciente], [diagnostico], [indicaciones], [fechaCita], [frecuenciaCardiaca], [frecuenciaRespiratoria], [pulso], [temperatura], [id_condicion], [fechaProximaCita]) VALUES (21, 19, N'', N'', CAST(N'2024-11-23T20:19:43.337' AS DateTime), 100, 10, 100, 35, N'2', CAST(N'2024-12-23T20:19:43.337' AS DateTime))
INSERT [dbo].[Cita] ([id_cita], [id_Paciente], [diagnostico], [indicaciones], [fechaCita], [frecuenciaCardiaca], [frecuenciaRespiratoria], [pulso], [temperatura], [id_condicion], [fechaProximaCita]) VALUES (22, 16, N'', N'', CAST(N'2024-11-23T21:40:00.000' AS DateTime), 100, 10, 100, 35, N'1', CAST(N'2024-12-23T21:40:00.000' AS DateTime))
INSERT [dbo].[Cita] ([id_cita], [id_Paciente], [diagnostico], [indicaciones], [fechaCita], [frecuenciaCardiaca], [frecuenciaRespiratoria], [pulso], [temperatura], [id_condicion], [fechaProximaCita]) VALUES (23, 18, N'', N'', CAST(N'2024-11-25T08:20:49.983' AS DateTime), 100, 10, 100, 35, N'1', CAST(N'2025-01-24T08:20:49.983' AS DateTime))
INSERT [dbo].[Cita] ([id_cita], [id_Paciente], [diagnostico], [indicaciones], [fechaCita], [frecuenciaCardiaca], [frecuenciaRespiratoria], [pulso], [temperatura], [id_condicion], [fechaProximaCita]) VALUES (24, 18, N'', N'', CAST(N'2024-11-25T09:21:00.000' AS DateTime), 100, 10, 100, 35, N'1', CAST(N'2025-01-24T09:21:00.000' AS DateTime))
INSERT [dbo].[Cita] ([id_cita], [id_Paciente], [diagnostico], [indicaciones], [fechaCita], [frecuenciaCardiaca], [frecuenciaRespiratoria], [pulso], [temperatura], [id_condicion], [fechaProximaCita]) VALUES (25, 3, N'', N'', CAST(N'2024-11-25T10:46:00.000' AS DateTime), 100, 10, 100, 35, N'1', CAST(N'2025-01-24T10:46:00.000' AS DateTime))
INSERT [dbo].[Cita] ([id_cita], [id_Paciente], [diagnostico], [indicaciones], [fechaCita], [frecuenciaCardiaca], [frecuenciaRespiratoria], [pulso], [temperatura], [id_condicion], [fechaProximaCita]) VALUES (26, 3, N'', N'', CAST(N'2024-11-25T11:47:00.000' AS DateTime), 100, 10, 100, 35, N'2', CAST(N'2024-12-09T11:47:00.000' AS DateTime))
INSERT [dbo].[Cita] ([id_cita], [id_Paciente], [diagnostico], [indicaciones], [fechaCita], [frecuenciaCardiaca], [frecuenciaRespiratoria], [pulso], [temperatura], [id_condicion], [fechaProximaCita]) VALUES (27, 2, N'', N'', CAST(N'2024-11-26T08:51:00.000' AS DateTime), 100, 10, 100, 35, N'1', NULL)
INSERT [dbo].[Cita] ([id_cita], [id_Paciente], [diagnostico], [indicaciones], [fechaCita], [frecuenciaCardiaca], [frecuenciaRespiratoria], [pulso], [temperatura], [id_condicion], [fechaProximaCita]) VALUES (28, 20, N'Esta bien', N'Darle mas agua', CAST(N'2024-09-19T09:01:00.000' AS DateTime), 105, 8, 85, 36, N'3', NULL)
INSERT [dbo].[Cita] ([id_cita], [id_Paciente], [diagnostico], [indicaciones], [fechaCita], [frecuenciaCardiaca], [frecuenciaRespiratoria], [pulso], [temperatura], [id_condicion], [fechaProximaCita]) VALUES (29, 4, N'Enfermito', N'Panadol', CAST(N'2024-12-06T09:11:00.000' AS DateTime), 100, 10, 100, 0, N'2', NULL)
INSERT [dbo].[Cita] ([id_cita], [id_Paciente], [diagnostico], [indicaciones], [fechaCita], [frecuenciaCardiaca], [frecuenciaRespiratoria], [pulso], [temperatura], [id_condicion], [fechaProximaCita]) VALUES (30, 20, N'', N'', CAST(N'2024-11-25T22:22:10.897' AS DateTime), 100, 10, 100, 35, N'1', CAST(N'2024-12-09T22:22:10.897' AS DateTime))
INSERT [dbo].[Cita] ([id_cita], [id_Paciente], [diagnostico], [indicaciones], [fechaCita], [frecuenciaCardiaca], [frecuenciaRespiratoria], [pulso], [temperatura], [id_condicion], [fechaProximaCita]) VALUES (31, 20, N'', N'', CAST(N'2024-11-26T22:22:00.000' AS DateTime), 100, 10, 100, 35, N'1', CAST(N'2024-12-03T22:22:00.000' AS DateTime))
INSERT [dbo].[Cita] ([id_cita], [id_Paciente], [diagnostico], [indicaciones], [fechaCita], [frecuenciaCardiaca], [frecuenciaRespiratoria], [pulso], [temperatura], [id_condicion], [fechaProximaCita]) VALUES (32, 2, N'', N'', CAST(N'2024-11-11T22:45:00.000' AS DateTime), 100, 10, 100, 35, N'3', CAST(N'2024-11-18T22:45:00.000' AS DateTime))
INSERT [dbo].[Cita] ([id_cita], [id_Paciente], [diagnostico], [indicaciones], [fechaCita], [frecuenciaCardiaca], [frecuenciaRespiratoria], [pulso], [temperatura], [id_condicion], [fechaProximaCita]) VALUES (33, 2, N'', N'', CAST(N'2024-11-25T23:37:04.797' AS DateTime), 100, 10, 100, 35, N'2', CAST(N'2024-12-02T23:37:04.797' AS DateTime))
SET IDENTITY_INSERT [dbo].[Cita] OFF
GO
INSERT [dbo].[Cita_Actitud] ([id_cita], [id_actitud]) VALUES (1, N'2')
INSERT [dbo].[Cita_Actitud] ([id_cita], [id_actitud]) VALUES (4, N'2')
INSERT [dbo].[Cita_Actitud] ([id_cita], [id_actitud]) VALUES (5, N'3')
INSERT [dbo].[Cita_Actitud] ([id_cita], [id_actitud]) VALUES (6, N'2')
INSERT [dbo].[Cita_Actitud] ([id_cita], [id_actitud]) VALUES (7, N'2')
INSERT [dbo].[Cita_Actitud] ([id_cita], [id_actitud]) VALUES (12, N'1')
INSERT [dbo].[Cita_Actitud] ([id_cita], [id_actitud]) VALUES (13, N'2')
INSERT [dbo].[Cita_Actitud] ([id_cita], [id_actitud]) VALUES (14, N'1')
INSERT [dbo].[Cita_Actitud] ([id_cita], [id_actitud]) VALUES (15, N'1')
INSERT [dbo].[Cita_Actitud] ([id_cita], [id_actitud]) VALUES (16, N'1')
INSERT [dbo].[Cita_Actitud] ([id_cita], [id_actitud]) VALUES (19, N'1')
INSERT [dbo].[Cita_Actitud] ([id_cita], [id_actitud]) VALUES (20, N'1')
INSERT [dbo].[Cita_Actitud] ([id_cita], [id_actitud]) VALUES (21, N'1')
INSERT [dbo].[Cita_Actitud] ([id_cita], [id_actitud]) VALUES (22, N'2')
INSERT [dbo].[Cita_Actitud] ([id_cita], [id_actitud]) VALUES (23, N'1')
INSERT [dbo].[Cita_Actitud] ([id_cita], [id_actitud]) VALUES (24, N'1')
INSERT [dbo].[Cita_Actitud] ([id_cita], [id_actitud]) VALUES (25, N'1')
INSERT [dbo].[Cita_Actitud] ([id_cita], [id_actitud]) VALUES (25, N'2')
INSERT [dbo].[Cita_Actitud] ([id_cita], [id_actitud]) VALUES (25, N'3')
INSERT [dbo].[Cita_Actitud] ([id_cita], [id_actitud]) VALUES (26, N'1')
INSERT [dbo].[Cita_Actitud] ([id_cita], [id_actitud]) VALUES (26, N'2')
INSERT [dbo].[Cita_Actitud] ([id_cita], [id_actitud]) VALUES (26, N'3')
INSERT [dbo].[Cita_Actitud] ([id_cita], [id_actitud]) VALUES (27, N'1')
INSERT [dbo].[Cita_Actitud] ([id_cita], [id_actitud]) VALUES (28, N'1')
INSERT [dbo].[Cita_Actitud] ([id_cita], [id_actitud]) VALUES (29, N'1')
INSERT [dbo].[Cita_Actitud] ([id_cita], [id_actitud]) VALUES (30, N'1')
INSERT [dbo].[Cita_Actitud] ([id_cita], [id_actitud]) VALUES (31, N'1')
INSERT [dbo].[Cita_Actitud] ([id_cita], [id_actitud]) VALUES (32, N'1')
INSERT [dbo].[Cita_Actitud] ([id_cita], [id_actitud]) VALUES (33, N'1')
GO
INSERT [dbo].[Cita_Evaluacion] ([id_cita], [id_evaluacion]) VALUES (1, 2004)
INSERT [dbo].[Cita_Evaluacion] ([id_cita], [id_evaluacion]) VALUES (1, 2005)
INSERT [dbo].[Cita_Evaluacion] ([id_cita], [id_evaluacion]) VALUES (1, 2006)
INSERT [dbo].[Cita_Evaluacion] ([id_cita], [id_evaluacion]) VALUES (4, 2007)
INSERT [dbo].[Cita_Evaluacion] ([id_cita], [id_evaluacion]) VALUES (4, 2008)
INSERT [dbo].[Cita_Evaluacion] ([id_cita], [id_evaluacion]) VALUES (4, 2009)
INSERT [dbo].[Cita_Evaluacion] ([id_cita], [id_evaluacion]) VALUES (5, 2010)
INSERT [dbo].[Cita_Evaluacion] ([id_cita], [id_evaluacion]) VALUES (5, 2011)
INSERT [dbo].[Cita_Evaluacion] ([id_cita], [id_evaluacion]) VALUES (6, 2012)
INSERT [dbo].[Cita_Evaluacion] ([id_cita], [id_evaluacion]) VALUES (7, 2013)
INSERT [dbo].[Cita_Evaluacion] ([id_cita], [id_evaluacion]) VALUES (12, 2014)
INSERT [dbo].[Cita_Evaluacion] ([id_cita], [id_evaluacion]) VALUES (13, 2015)
INSERT [dbo].[Cita_Evaluacion] ([id_cita], [id_evaluacion]) VALUES (13, 2016)
INSERT [dbo].[Cita_Evaluacion] ([id_cita], [id_evaluacion]) VALUES (25, 2017)
INSERT [dbo].[Cita_Evaluacion] ([id_cita], [id_evaluacion]) VALUES (25, 2018)
INSERT [dbo].[Cita_Evaluacion] ([id_cita], [id_evaluacion]) VALUES (25, 2019)
INSERT [dbo].[Cita_Evaluacion] ([id_cita], [id_evaluacion]) VALUES (25, 2020)
INSERT [dbo].[Cita_Evaluacion] ([id_cita], [id_evaluacion]) VALUES (25, 2021)
INSERT [dbo].[Cita_Evaluacion] ([id_cita], [id_evaluacion]) VALUES (25, 2022)
INSERT [dbo].[Cita_Evaluacion] ([id_cita], [id_evaluacion]) VALUES (25, 2023)
INSERT [dbo].[Cita_Evaluacion] ([id_cita], [id_evaluacion]) VALUES (25, 2024)
INSERT [dbo].[Cita_Evaluacion] ([id_cita], [id_evaluacion]) VALUES (26, 2025)
INSERT [dbo].[Cita_Evaluacion] ([id_cita], [id_evaluacion]) VALUES (26, 2026)
INSERT [dbo].[Cita_Evaluacion] ([id_cita], [id_evaluacion]) VALUES (26, 2027)
INSERT [dbo].[Cita_Evaluacion] ([id_cita], [id_evaluacion]) VALUES (26, 2028)
INSERT [dbo].[Cita_Evaluacion] ([id_cita], [id_evaluacion]) VALUES (26, 2029)
INSERT [dbo].[Cita_Evaluacion] ([id_cita], [id_evaluacion]) VALUES (26, 2030)
INSERT [dbo].[Cita_Evaluacion] ([id_cita], [id_evaluacion]) VALUES (26, 2031)
INSERT [dbo].[Cita_Evaluacion] ([id_cita], [id_evaluacion]) VALUES (26, 2032)
INSERT [dbo].[Cita_Evaluacion] ([id_cita], [id_evaluacion]) VALUES (28, 2033)
INSERT [dbo].[Cita_Evaluacion] ([id_cita], [id_evaluacion]) VALUES (29, 2034)
INSERT [dbo].[Cita_Evaluacion] ([id_cita], [id_evaluacion]) VALUES (29, 2035)
GO
SET IDENTITY_INSERT [dbo].[Cita_motivo] ON 

INSERT [dbo].[Cita_motivo] ([id_Cita_Motivo], [id_motivo], [id_cita], [id_vacuna], [precio], [aplica_examen]) VALUES (2010, 1, 1, NULL, 8000, 1)
INSERT [dbo].[Cita_motivo] ([id_Cita_Motivo], [id_motivo], [id_cita], [id_vacuna], [precio], [aplica_examen]) VALUES (2011, 2, 1, 1, 4657, 0)
INSERT [dbo].[Cita_motivo] ([id_Cita_Motivo], [id_motivo], [id_cita], [id_vacuna], [precio], [aplica_examen]) VALUES (2012, 2, 1, 5, 6500, 0)
INSERT [dbo].[Cita_motivo] ([id_Cita_Motivo], [id_motivo], [id_cita], [id_vacuna], [precio], [aplica_examen]) VALUES (2013, 3, 1, NULL, 50000, 1)
INSERT [dbo].[Cita_motivo] ([id_Cita_Motivo], [id_motivo], [id_cita], [id_vacuna], [precio], [aplica_examen]) VALUES (2014, 4, 2, NULL, 2000, 0)
INSERT [dbo].[Cita_motivo] ([id_Cita_Motivo], [id_motivo], [id_cita], [id_vacuna], [precio], [aplica_examen]) VALUES (2015, 1, 4, NULL, 8000, 1)
INSERT [dbo].[Cita_motivo] ([id_Cita_Motivo], [id_motivo], [id_cita], [id_vacuna], [precio], [aplica_examen]) VALUES (2016, 2, 4, 2, 5500, 0)
INSERT [dbo].[Cita_motivo] ([id_Cita_Motivo], [id_motivo], [id_cita], [id_vacuna], [precio], [aplica_examen]) VALUES (2017, 3, 4, NULL, 10000, 1)
INSERT [dbo].[Cita_motivo] ([id_Cita_Motivo], [id_motivo], [id_cita], [id_vacuna], [precio], [aplica_examen]) VALUES (2018, 2, 5, 6, 4567, 0)
INSERT [dbo].[Cita_motivo] ([id_Cita_Motivo], [id_motivo], [id_cita], [id_vacuna], [precio], [aplica_examen]) VALUES (2019, 2, 6, 2, 5500, 0)
INSERT [dbo].[Cita_motivo] ([id_Cita_Motivo], [id_motivo], [id_cita], [id_vacuna], [precio], [aplica_examen]) VALUES (2020, 1, 6, NULL, 8000, 1)
INSERT [dbo].[Cita_motivo] ([id_Cita_Motivo], [id_motivo], [id_cita], [id_vacuna], [precio], [aplica_examen]) VALUES (2021, 3, 6, NULL, 5000, 0)
INSERT [dbo].[Cita_motivo] ([id_Cita_Motivo], [id_motivo], [id_cita], [id_vacuna], [precio], [aplica_examen]) VALUES (2022, 1, 7, NULL, 8000, 0)
INSERT [dbo].[Cita_motivo] ([id_Cita_Motivo], [id_motivo], [id_cita], [id_vacuna], [precio], [aplica_examen]) VALUES (2023, 2, 7, 8, 9000, 0)
INSERT [dbo].[Cita_motivo] ([id_Cita_Motivo], [id_motivo], [id_cita], [id_vacuna], [precio], [aplica_examen]) VALUES (2024, 1, 12, NULL, 8000, 0)
INSERT [dbo].[Cita_motivo] ([id_Cita_Motivo], [id_motivo], [id_cita], [id_vacuna], [precio], [aplica_examen]) VALUES (2025, 1, 13, NULL, 8000, 0)
INSERT [dbo].[Cita_motivo] ([id_Cita_Motivo], [id_motivo], [id_cita], [id_vacuna], [precio], [aplica_examen]) VALUES (2026, 2, 13, 1, 4657, 0)
INSERT [dbo].[Cita_motivo] ([id_Cita_Motivo], [id_motivo], [id_cita], [id_vacuna], [precio], [aplica_examen]) VALUES (2027, 2, 13, 5, 6500, 0)
INSERT [dbo].[Cita_motivo] ([id_Cita_Motivo], [id_motivo], [id_cita], [id_vacuna], [precio], [aplica_examen]) VALUES (2028, 3, 13, NULL, 50000, 1)
INSERT [dbo].[Cita_motivo] ([id_Cita_Motivo], [id_motivo], [id_cita], [id_vacuna], [precio], [aplica_examen]) VALUES (2029, 5, 13, NULL, 10000, 0)
INSERT [dbo].[Cita_motivo] ([id_Cita_Motivo], [id_motivo], [id_cita], [id_vacuna], [precio], [aplica_examen]) VALUES (2030, 2, 14, 1, 4657, 0)
INSERT [dbo].[Cita_motivo] ([id_Cita_Motivo], [id_motivo], [id_cita], [id_vacuna], [precio], [aplica_examen]) VALUES (2031, 1, 15, NULL, 8000, 1)
INSERT [dbo].[Cita_motivo] ([id_Cita_Motivo], [id_motivo], [id_cita], [id_vacuna], [precio], [aplica_examen]) VALUES (2032, 1, 16, NULL, 8000, 1)
INSERT [dbo].[Cita_motivo] ([id_Cita_Motivo], [id_motivo], [id_cita], [id_vacuna], [precio], [aplica_examen]) VALUES (2034, 4, 21, NULL, 20000, 0)
INSERT [dbo].[Cita_motivo] ([id_Cita_Motivo], [id_motivo], [id_cita], [id_vacuna], [precio], [aplica_examen]) VALUES (2035, 1, 23, NULL, 8000, 1)
INSERT [dbo].[Cita_motivo] ([id_Cita_Motivo], [id_motivo], [id_cita], [id_vacuna], [precio], [aplica_examen]) VALUES (2036, 1, 24, NULL, 8000, 1)
INSERT [dbo].[Cita_motivo] ([id_Cita_Motivo], [id_motivo], [id_cita], [id_vacuna], [precio], [aplica_examen]) VALUES (2037, 2, 26, 1, 4657, 0)
INSERT [dbo].[Cita_motivo] ([id_Cita_Motivo], [id_motivo], [id_cita], [id_vacuna], [precio], [aplica_examen]) VALUES (2038, 2, 26, 5, 6500, 0)
INSERT [dbo].[Cita_motivo] ([id_Cita_Motivo], [id_motivo], [id_cita], [id_vacuna], [precio], [aplica_examen]) VALUES (2039, 2, 26, 15, 8765, 0)
INSERT [dbo].[Cita_motivo] ([id_Cita_Motivo], [id_motivo], [id_cita], [id_vacuna], [precio], [aplica_examen]) VALUES (2040, 2, 27, 1, 4657, 0)
INSERT [dbo].[Cita_motivo] ([id_Cita_Motivo], [id_motivo], [id_cita], [id_vacuna], [precio], [aplica_examen]) VALUES (2041, 2, 27, 1, 4657, 0)
INSERT [dbo].[Cita_motivo] ([id_Cita_Motivo], [id_motivo], [id_cita], [id_vacuna], [precio], [aplica_examen]) VALUES (2042, 2, 27, 1, 4657, 0)
INSERT [dbo].[Cita_motivo] ([id_Cita_Motivo], [id_motivo], [id_cita], [id_vacuna], [precio], [aplica_examen]) VALUES (2043, 2, 28, 5, 6500, 0)
INSERT [dbo].[Cita_motivo] ([id_Cita_Motivo], [id_motivo], [id_cita], [id_vacuna], [precio], [aplica_examen]) VALUES (2044, 2, 29, 2, 5500, 0)
INSERT [dbo].[Cita_motivo] ([id_Cita_Motivo], [id_motivo], [id_cita], [id_vacuna], [precio], [aplica_examen]) VALUES (2045, 2, 29, 6, 4567, 0)
INSERT [dbo].[Cita_motivo] ([id_Cita_Motivo], [id_motivo], [id_cita], [id_vacuna], [precio], [aplica_examen]) VALUES (2046, 1, 31, NULL, 8000, 1)
SET IDENTITY_INSERT [dbo].[Cita_motivo] OFF
GO
INSERT [dbo].[Cita_PruebaLaboratorio] ([id_cita], [id_pruebaLaboratorio], [id_subCategoria]) VALUES (1, 1, 1)
INSERT [dbo].[Cita_PruebaLaboratorio] ([id_cita], [id_pruebaLaboratorio], [id_subCategoria]) VALUES (1, 1, 2)
INSERT [dbo].[Cita_PruebaLaboratorio] ([id_cita], [id_pruebaLaboratorio], [id_subCategoria]) VALUES (1, 2, 5)
INSERT [dbo].[Cita_PruebaLaboratorio] ([id_cita], [id_pruebaLaboratorio], [id_subCategoria]) VALUES (1, 4, 12)
INSERT [dbo].[Cita_PruebaLaboratorio] ([id_cita], [id_pruebaLaboratorio], [id_subCategoria]) VALUES (4, 1, 1)
INSERT [dbo].[Cita_PruebaLaboratorio] ([id_cita], [id_pruebaLaboratorio], [id_subCategoria]) VALUES (4, 1, 2)
INSERT [dbo].[Cita_PruebaLaboratorio] ([id_cita], [id_pruebaLaboratorio], [id_subCategoria]) VALUES (4, 2, 5)
INSERT [dbo].[Cita_PruebaLaboratorio] ([id_cita], [id_pruebaLaboratorio], [id_subCategoria]) VALUES (4, 3, 7)
INSERT [dbo].[Cita_PruebaLaboratorio] ([id_cita], [id_pruebaLaboratorio], [id_subCategoria]) VALUES (4, 3, 8)
INSERT [dbo].[Cita_PruebaLaboratorio] ([id_cita], [id_pruebaLaboratorio], [id_subCategoria]) VALUES (13, 1, 1)
INSERT [dbo].[Cita_PruebaLaboratorio] ([id_cita], [id_pruebaLaboratorio], [id_subCategoria]) VALUES (13, 1, 13)
INSERT [dbo].[Cita_PruebaLaboratorio] ([id_cita], [id_pruebaLaboratorio], [id_subCategoria]) VALUES (13, 2, 5)
INSERT [dbo].[Cita_PruebaLaboratorio] ([id_cita], [id_pruebaLaboratorio], [id_subCategoria]) VALUES (13, 3, 9)
INSERT [dbo].[Cita_PruebaLaboratorio] ([id_cita], [id_pruebaLaboratorio], [id_subCategoria]) VALUES (13, 3, 10)
INSERT [dbo].[Cita_PruebaLaboratorio] ([id_cita], [id_pruebaLaboratorio], [id_subCategoria]) VALUES (13, 4, 11)
INSERT [dbo].[Cita_PruebaLaboratorio] ([id_cita], [id_pruebaLaboratorio], [id_subCategoria]) VALUES (15, 1, 1)
INSERT [dbo].[Cita_PruebaLaboratorio] ([id_cita], [id_pruebaLaboratorio], [id_subCategoria]) VALUES (22, 1, 2)
INSERT [dbo].[Cita_PruebaLaboratorio] ([id_cita], [id_pruebaLaboratorio], [id_subCategoria]) VALUES (22, 4, 12)
INSERT [dbo].[Cita_PruebaLaboratorio] ([id_cita], [id_pruebaLaboratorio], [id_subCategoria]) VALUES (26, 1, 1)
INSERT [dbo].[Cita_PruebaLaboratorio] ([id_cita], [id_pruebaLaboratorio], [id_subCategoria]) VALUES (26, 1, 2)
INSERT [dbo].[Cita_PruebaLaboratorio] ([id_cita], [id_pruebaLaboratorio], [id_subCategoria]) VALUES (26, 1, 3)
INSERT [dbo].[Cita_PruebaLaboratorio] ([id_cita], [id_pruebaLaboratorio], [id_subCategoria]) VALUES (26, 1, 13)
INSERT [dbo].[Cita_PruebaLaboratorio] ([id_cita], [id_pruebaLaboratorio], [id_subCategoria]) VALUES (26, 2, 5)
INSERT [dbo].[Cita_PruebaLaboratorio] ([id_cita], [id_pruebaLaboratorio], [id_subCategoria]) VALUES (26, 2, 6)
INSERT [dbo].[Cita_PruebaLaboratorio] ([id_cita], [id_pruebaLaboratorio], [id_subCategoria]) VALUES (26, 3, 7)
INSERT [dbo].[Cita_PruebaLaboratorio] ([id_cita], [id_pruebaLaboratorio], [id_subCategoria]) VALUES (26, 3, 8)
INSERT [dbo].[Cita_PruebaLaboratorio] ([id_cita], [id_pruebaLaboratorio], [id_subCategoria]) VALUES (26, 3, 9)
INSERT [dbo].[Cita_PruebaLaboratorio] ([id_cita], [id_pruebaLaboratorio], [id_subCategoria]) VALUES (26, 3, 10)
INSERT [dbo].[Cita_PruebaLaboratorio] ([id_cita], [id_pruebaLaboratorio], [id_subCategoria]) VALUES (26, 4, 11)
INSERT [dbo].[Cita_PruebaLaboratorio] ([id_cita], [id_pruebaLaboratorio], [id_subCategoria]) VALUES (26, 4, 12)
INSERT [dbo].[Cita_PruebaLaboratorio] ([id_cita], [id_pruebaLaboratorio], [id_subCategoria]) VALUES (28, 2, 6)
INSERT [dbo].[Cita_PruebaLaboratorio] ([id_cita], [id_pruebaLaboratorio], [id_subCategoria]) VALUES (29, 2, 5)
INSERT [dbo].[Cita_PruebaLaboratorio] ([id_cita], [id_pruebaLaboratorio], [id_subCategoria]) VALUES (29, 3, 8)
INSERT [dbo].[Cita_PruebaLaboratorio] ([id_cita], [id_pruebaLaboratorio], [id_subCategoria]) VALUES (29, 3, 9)
INSERT [dbo].[Cita_PruebaLaboratorio] ([id_cita], [id_pruebaLaboratorio], [id_subCategoria]) VALUES (29, 4, 12)
INSERT [dbo].[Cita_PruebaLaboratorio] ([id_cita], [id_pruebaLaboratorio], [id_subCategoria]) VALUES (33, 1, 1)
GO
INSERT [dbo].[Condicion] ([id_condicion], [descripcion]) VALUES (N'1', N'BAJO_PESO      ')
INSERT [dbo].[Condicion] ([id_condicion], [descripcion]) VALUES (N'2', N'SOBRE_PESO     ')
INSERT [dbo].[Condicion] ([id_condicion], [descripcion]) VALUES (N'3', N'NORMAL         ')
GO
INSERT [dbo].[Dueño] ([cedula], [nombre], [direccion], [numero_telefono]) VALUES (N'111222333', N'Adrian', N'Santa Lucía                                                                                         ', N'10295764')
INSERT [dbo].[Dueño] ([cedula], [nombre], [direccion], [numero_telefono]) VALUES (N'121212122', N'Chester Alberto', N'Heredia                                                                                             ', N'91829821')
INSERT [dbo].[Dueño] ([cedula], [nombre], [direccion], [numero_telefono]) VALUES (N'123456789', N'Ronaldo', N'Getsemaní                                                                                           ', N'88888888')
INSERT [dbo].[Dueño] ([cedula], [nombre], [direccion], [numero_telefono]) VALUES (N'240272014', N'Alejandro', N'San Rafael de Alajuela                                                                              ', N'12121212')
INSERT [dbo].[Dueño] ([cedula], [nombre], [direccion], [numero_telefono]) VALUES (N'402700734', N'Andrey Pérez', N'Getsemaní                                                                                           ', N'87716188')
INSERT [dbo].[Dueño] ([cedula], [nombre], [direccion], [numero_telefono]) VALUES (N'402720338', N'Jimena', N'San Rafael, Heredia                                                                                 ', N'33333333')
GO
SET IDENTITY_INSERT [dbo].[Especie] ON 

INSERT [dbo].[Especie] ([id_especie], [nombre_especie]) VALUES (1, N'Perro                         ')
INSERT [dbo].[Especie] ([id_especie], [nombre_especie]) VALUES (2, N'Gato                          ')
SET IDENTITY_INSERT [dbo].[Especie] OFF
GO
INSERT [dbo].[Estado] ([id_estado], [estado]) VALUES (N'1', N'NORMAL    ')
INSERT [dbo].[Estado] ([id_estado], [estado]) VALUES (N'2', N'ANORMAL   ')
GO
SET IDENTITY_INSERT [dbo].[Evaluacion] ON 

INSERT [dbo].[Evaluacion] ([id_evaluacion], [id_tipo_evaluacion], [id_estado]) VALUES (2004, N'4 ', N'1')
INSERT [dbo].[Evaluacion] ([id_evaluacion], [id_tipo_evaluacion], [id_estado]) VALUES (2005, N'5 ', N'1')
INSERT [dbo].[Evaluacion] ([id_evaluacion], [id_tipo_evaluacion], [id_estado]) VALUES (2006, N'6 ', N'1')
INSERT [dbo].[Evaluacion] ([id_evaluacion], [id_tipo_evaluacion], [id_estado]) VALUES (2007, N'1 ', N'2')
INSERT [dbo].[Evaluacion] ([id_evaluacion], [id_tipo_evaluacion], [id_estado]) VALUES (2008, N'2 ', N'2')
INSERT [dbo].[Evaluacion] ([id_evaluacion], [id_tipo_evaluacion], [id_estado]) VALUES (2009, N'3 ', N'2')
INSERT [dbo].[Evaluacion] ([id_evaluacion], [id_tipo_evaluacion], [id_estado]) VALUES (2010, N'7 ', N'1')
INSERT [dbo].[Evaluacion] ([id_evaluacion], [id_tipo_evaluacion], [id_estado]) VALUES (2011, N'5 ', N'2')
INSERT [dbo].[Evaluacion] ([id_evaluacion], [id_tipo_evaluacion], [id_estado]) VALUES (2012, N'1 ', N'2')
INSERT [dbo].[Evaluacion] ([id_evaluacion], [id_tipo_evaluacion], [id_estado]) VALUES (2013, N'1 ', N'2')
INSERT [dbo].[Evaluacion] ([id_evaluacion], [id_tipo_evaluacion], [id_estado]) VALUES (2014, N'2 ', N'1')
INSERT [dbo].[Evaluacion] ([id_evaluacion], [id_tipo_evaluacion], [id_estado]) VALUES (2015, N'1 ', N'2')
INSERT [dbo].[Evaluacion] ([id_evaluacion], [id_tipo_evaluacion], [id_estado]) VALUES (2016, N'2 ', N'2')
INSERT [dbo].[Evaluacion] ([id_evaluacion], [id_tipo_evaluacion], [id_estado]) VALUES (2017, N'1 ', N'1')
INSERT [dbo].[Evaluacion] ([id_evaluacion], [id_tipo_evaluacion], [id_estado]) VALUES (2018, N'2 ', N'1')
INSERT [dbo].[Evaluacion] ([id_evaluacion], [id_tipo_evaluacion], [id_estado]) VALUES (2019, N'3 ', N'1')
INSERT [dbo].[Evaluacion] ([id_evaluacion], [id_tipo_evaluacion], [id_estado]) VALUES (2020, N'4 ', N'1')
INSERT [dbo].[Evaluacion] ([id_evaluacion], [id_tipo_evaluacion], [id_estado]) VALUES (2021, N'5 ', N'1')
INSERT [dbo].[Evaluacion] ([id_evaluacion], [id_tipo_evaluacion], [id_estado]) VALUES (2022, N'6 ', N'1')
INSERT [dbo].[Evaluacion] ([id_evaluacion], [id_tipo_evaluacion], [id_estado]) VALUES (2023, N'7 ', N'1')
INSERT [dbo].[Evaluacion] ([id_evaluacion], [id_tipo_evaluacion], [id_estado]) VALUES (2024, N'8 ', N'1')
INSERT [dbo].[Evaluacion] ([id_evaluacion], [id_tipo_evaluacion], [id_estado]) VALUES (2025, N'1 ', N'2')
INSERT [dbo].[Evaluacion] ([id_evaluacion], [id_tipo_evaluacion], [id_estado]) VALUES (2026, N'2 ', N'2')
INSERT [dbo].[Evaluacion] ([id_evaluacion], [id_tipo_evaluacion], [id_estado]) VALUES (2027, N'3 ', N'2')
INSERT [dbo].[Evaluacion] ([id_evaluacion], [id_tipo_evaluacion], [id_estado]) VALUES (2028, N'4 ', N'2')
INSERT [dbo].[Evaluacion] ([id_evaluacion], [id_tipo_evaluacion], [id_estado]) VALUES (2029, N'5 ', N'2')
INSERT [dbo].[Evaluacion] ([id_evaluacion], [id_tipo_evaluacion], [id_estado]) VALUES (2030, N'6 ', N'2')
INSERT [dbo].[Evaluacion] ([id_evaluacion], [id_tipo_evaluacion], [id_estado]) VALUES (2031, N'7 ', N'2')
INSERT [dbo].[Evaluacion] ([id_evaluacion], [id_tipo_evaluacion], [id_estado]) VALUES (2032, N'8 ', N'2')
INSERT [dbo].[Evaluacion] ([id_evaluacion], [id_tipo_evaluacion], [id_estado]) VALUES (2033, N'3 ', N'1')
INSERT [dbo].[Evaluacion] ([id_evaluacion], [id_tipo_evaluacion], [id_estado]) VALUES (2034, N'6 ', N'2')
INSERT [dbo].[Evaluacion] ([id_evaluacion], [id_tipo_evaluacion], [id_estado]) VALUES (2035, N'4 ', N'2')
SET IDENTITY_INSERT [dbo].[Evaluacion] OFF
GO
SET IDENTITY_INSERT [dbo].[Motivo] ON 

INSERT [dbo].[Motivo] ([id_motivo], [descripcion], [precio], [aplica_examen], [tiene_vacuna]) VALUES (1, N'Chequeo general', 8000, 1, 0)
INSERT [dbo].[Motivo] ([id_motivo], [descripcion], [precio], [aplica_examen], [tiene_vacuna]) VALUES (2, N'Vacunación', 4657, 0, 1)
INSERT [dbo].[Motivo] ([id_motivo], [descripcion], [precio], [aplica_examen], [tiene_vacuna]) VALUES (3, N'Enfermedad', NULL, 1, 0)
INSERT [dbo].[Motivo] ([id_motivo], [descripcion], [precio], [aplica_examen], [tiene_vacuna]) VALUES (4, N'Desparacitación', 2000, 0, 0)
INSERT [dbo].[Motivo] ([id_motivo], [descripcion], [precio], [aplica_examen], [tiene_vacuna]) VALUES (5, N'Cirugía', NULL, 1, 0)
SET IDENTITY_INSERT [dbo].[Motivo] OFF
GO
SET IDENTITY_INSERT [dbo].[Paciente] ON 

INSERT [dbo].[Paciente] ([id_paciente], [cedula_dueño], [nombre], [sexo], [edad], [id_especie], [id_raza]) VALUES (2, N'402720338', N'Kiara', N'HEMBRA    ', 72, 1, 22)
INSERT [dbo].[Paciente] ([id_paciente], [cedula_dueño], [nombre], [sexo], [edad], [id_especie], [id_raza]) VALUES (3, N'402720338', N'Stella', N'HEMBRA    ', 15, 1, 22)
INSERT [dbo].[Paciente] ([id_paciente], [cedula_dueño], [nombre], [sexo], [edad], [id_especie], [id_raza]) VALUES (4, N'402700734', N'Molly', N'HEMBRA    ', 120, 2, 25)
INSERT [dbo].[Paciente] ([id_paciente], [cedula_dueño], [nombre], [sexo], [edad], [id_especie], [id_raza]) VALUES (5, N'402700734', N'Cooper', N'MACHO     ', 60, 2, 19)
INSERT [dbo].[Paciente] ([id_paciente], [cedula_dueño], [nombre], [sexo], [edad], [id_especie], [id_raza]) VALUES (6, N'240272014', N'Cooper', N'MACHO     ', 6, 2, 18)
INSERT [dbo].[Paciente] ([id_paciente], [cedula_dueño], [nombre], [sexo], [edad], [id_especie], [id_raza]) VALUES (10, N'402700734', N'Orejas', N'MACHO     ', 140, 1, 23)
INSERT [dbo].[Paciente] ([id_paciente], [cedula_dueño], [nombre], [sexo], [edad], [id_especie], [id_raza]) VALUES (11, N'402700734', N'Tito', N'MACHO     ', 100, 2, 18)
INSERT [dbo].[Paciente] ([id_paciente], [cedula_dueño], [nombre], [sexo], [edad], [id_especie], [id_raza]) VALUES (12, N'240272014', N'Nana', N'HEMBRA    ', 12, 1, 23)
INSERT [dbo].[Paciente] ([id_paciente], [cedula_dueño], [nombre], [sexo], [edad], [id_especie], [id_raza]) VALUES (13, N'123456789', N'Chuey', N'MACHO     ', 110, 1, 9)
INSERT [dbo].[Paciente] ([id_paciente], [cedula_dueño], [nombre], [sexo], [edad], [id_especie], [id_raza]) VALUES (16, N'240272014', N'Patroclo', N'MACHO     ', 4, 2, 28)
INSERT [dbo].[Paciente] ([id_paciente], [cedula_dueño], [nombre], [sexo], [edad], [id_especie], [id_raza]) VALUES (17, N'123456789', N'Don gato', N'MACHO     ', 105, 2, 15)
INSERT [dbo].[Paciente] ([id_paciente], [cedula_dueño], [nombre], [sexo], [edad], [id_especie], [id_raza]) VALUES (18, N'111222333', N'Loki', N'MACHO     ', 14, 1, 2)
INSERT [dbo].[Paciente] ([id_paciente], [cedula_dueño], [nombre], [sexo], [edad], [id_especie], [id_raza]) VALUES (19, N'111222333', N'Buda', N'MACHO     ', 120, 1, 1)
INSERT [dbo].[Paciente] ([id_paciente], [cedula_dueño], [nombre], [sexo], [edad], [id_especie], [id_raza]) VALUES (20, N'121212122', N'Rempalago', N'MACHO     ', 8, 1, 3)
SET IDENTITY_INSERT [dbo].[Paciente] OFF
GO
INSERT [dbo].[PruebaLaboratorio] ([id_prueba], [precio], [nombre]) VALUES (1, NULL, N'Sangre')
INSERT [dbo].[PruebaLaboratorio] ([id_prueba], [precio], [nombre]) VALUES (2, NULL, N'Heces')
INSERT [dbo].[PruebaLaboratorio] ([id_prueba], [precio], [nombre]) VALUES (3, NULL, N'Orina')
INSERT [dbo].[PruebaLaboratorio] ([id_prueba], [precio], [nombre]) VALUES (4, NULL, N'Cultivos')
GO
SET IDENTITY_INSERT [dbo].[Raza] ON 

INSERT [dbo].[Raza] ([id_raza], [id_especie], [nombre_raza]) VALUES (1, 1, N'Labrador Retriever            ')
INSERT [dbo].[Raza] ([id_raza], [id_especie], [nombre_raza]) VALUES (2, 1, N'Golden Retriever              ')
INSERT [dbo].[Raza] ([id_raza], [id_especie], [nombre_raza]) VALUES (3, 1, N'Pastor Alemán                 ')
INSERT [dbo].[Raza] ([id_raza], [id_especie], [nombre_raza]) VALUES (4, 1, N'BullDog                       ')
INSERT [dbo].[Raza] ([id_raza], [id_especie], [nombre_raza]) VALUES (5, 1, N'Beagle                        ')
INSERT [dbo].[Raza] ([id_raza], [id_especie], [nombre_raza]) VALUES (6, 1, N'Poodle                        ')
INSERT [dbo].[Raza] ([id_raza], [id_especie], [nombre_raza]) VALUES (7, 1, N'RottWeiler                    ')
INSERT [dbo].[Raza] ([id_raza], [id_especie], [nombre_raza]) VALUES (8, 1, N'Yorkshire Terrier             ')
INSERT [dbo].[Raza] ([id_raza], [id_especie], [nombre_raza]) VALUES (9, 1, N'Perro salchicha               ')
INSERT [dbo].[Raza] ([id_raza], [id_especie], [nombre_raza]) VALUES (10, 2, N'American Shorthair            ')
INSERT [dbo].[Raza] ([id_raza], [id_especie], [nombre_raza]) VALUES (11, 2, N'Bengal                        ')
INSERT [dbo].[Raza] ([id_raza], [id_especie], [nombre_raza]) VALUES (12, 2, N'British Shorthair             ')
INSERT [dbo].[Raza] ([id_raza], [id_especie], [nombre_raza]) VALUES (13, 2, N'Maine Coon                    ')
INSERT [dbo].[Raza] ([id_raza], [id_especie], [nombre_raza]) VALUES (14, 2, N'Norwegian Forest Cat          ')
INSERT [dbo].[Raza] ([id_raza], [id_especie], [nombre_raza]) VALUES (15, 2, N'Persian                       ')
INSERT [dbo].[Raza] ([id_raza], [id_especie], [nombre_raza]) VALUES (16, 2, N'Ragdoll                       ')
INSERT [dbo].[Raza] ([id_raza], [id_especie], [nombre_raza]) VALUES (17, 2, N'Scottish Fold                 ')
INSERT [dbo].[Raza] ([id_raza], [id_especie], [nombre_raza]) VALUES (18, 2, N'Siamese                       ')
INSERT [dbo].[Raza] ([id_raza], [id_especie], [nombre_raza]) VALUES (19, 2, N'Criollo                       ')
INSERT [dbo].[Raza] ([id_raza], [id_especie], [nombre_raza]) VALUES (20, 1, N'Boxer                         ')
INSERT [dbo].[Raza] ([id_raza], [id_especie], [nombre_raza]) VALUES (21, 1, N'Schnauzer                     ')
INSERT [dbo].[Raza] ([id_raza], [id_especie], [nombre_raza]) VALUES (22, 1, N'Chihuahua                     ')
INSERT [dbo].[Raza] ([id_raza], [id_especie], [nombre_raza]) VALUES (23, 1, N'Criollo                       ')
INSERT [dbo].[Raza] ([id_raza], [id_especie], [nombre_raza]) VALUES (25, 2, N'Bombay                        ')
INSERT [dbo].[Raza] ([id_raza], [id_especie], [nombre_raza]) VALUES (28, 2, N'Esfinge                       ')
INSERT [dbo].[Raza] ([id_raza], [id_especie], [nombre_raza]) VALUES (30, 1, N'American Staffordshire        ')
SET IDENTITY_INSERT [dbo].[Raza] OFF
GO
SET IDENTITY_INSERT [dbo].[SubCategoriaPrueba] ON 

INSERT [dbo].[SubCategoriaPrueba] ([id_subCategoria], [id_prueba], [nombre], [precio]) VALUES (1, 1, N'Serie roja', 3200)
INSERT [dbo].[SubCategoriaPrueba] ([id_subCategoria], [id_prueba], [nombre], [precio]) VALUES (2, 1, N'Serie blanca', 3200)
INSERT [dbo].[SubCategoriaPrueba] ([id_subCategoria], [id_prueba], [nombre], [precio]) VALUES (3, 1, N'Plaquetas', 3200)
INSERT [dbo].[SubCategoriaPrueba] ([id_subCategoria], [id_prueba], [nombre], [precio]) VALUES (5, 2, N'Sangre en heces', 4000)
INSERT [dbo].[SubCategoriaPrueba] ([id_subCategoria], [id_prueba], [nombre], [precio]) VALUES (6, 2, N'Parásitos', 4000)
INSERT [dbo].[SubCategoriaPrueba] ([id_subCategoria], [id_prueba], [nombre], [precio]) VALUES (7, 3, N'Sedimientos', 3600)
INSERT [dbo].[SubCategoriaPrueba] ([id_subCategoria], [id_prueba], [nombre], [precio]) VALUES (8, 3, N'Proteínas', 3600)
INSERT [dbo].[SubCategoriaPrueba] ([id_subCategoria], [id_prueba], [nombre], [precio]) VALUES (9, 3, N'Cultivo para hongos', 3600)
INSERT [dbo].[SubCategoriaPrueba] ([id_subCategoria], [id_prueba], [nombre], [precio]) VALUES (10, 3, N'Bacterias', 3600)
INSERT [dbo].[SubCategoriaPrueba] ([id_subCategoria], [id_prueba], [nombre], [precio]) VALUES (11, 4, N'Hongos', 4800)
INSERT [dbo].[SubCategoriaPrueba] ([id_subCategoria], [id_prueba], [nombre], [precio]) VALUES (12, 4, N'Bacterias', 4800)
INSERT [dbo].[SubCategoriaPrueba] ([id_subCategoria], [id_prueba], [nombre], [precio]) VALUES (13, 1, N'Coagulación', 3200)
SET IDENTITY_INSERT [dbo].[SubCategoriaPrueba] OFF
GO
INSERT [dbo].[Tipo_evaluacion] ([id_tipo_evaluacion], [tipo_evaluacion]) VALUES (N'1 ', N'PIEL                ')
INSERT [dbo].[Tipo_evaluacion] ([id_tipo_evaluacion], [tipo_evaluacion]) VALUES (N'2 ', N'OJOS                ')
INSERT [dbo].[Tipo_evaluacion] ([id_tipo_evaluacion], [tipo_evaluacion]) VALUES (N'3 ', N'OREJAS              ')
INSERT [dbo].[Tipo_evaluacion] ([id_tipo_evaluacion], [tipo_evaluacion]) VALUES (N'4 ', N'MEMBRANAS_MUCOSAS   ')
INSERT [dbo].[Tipo_evaluacion] ([id_tipo_evaluacion], [tipo_evaluacion]) VALUES (N'5 ', N'DIENTES             ')
INSERT [dbo].[Tipo_evaluacion] ([id_tipo_evaluacion], [tipo_evaluacion]) VALUES (N'6 ', N'NARIZ               ')
INSERT [dbo].[Tipo_evaluacion] ([id_tipo_evaluacion], [tipo_evaluacion]) VALUES (N'7 ', N'PELO                ')
INSERT [dbo].[Tipo_evaluacion] ([id_tipo_evaluacion], [tipo_evaluacion]) VALUES (N'8 ', N'HIDRATACION         ')
GO
SET IDENTITY_INSERT [dbo].[Usuario] ON 

INSERT [dbo].[Usuario] ([id_usuario], [nombre_usuario], [contraseña]) VALUES (1, N'admin', N'123456')
INSERT [dbo].[Usuario] ([id_usuario], [nombre_usuario], [contraseña]) VALUES (2, N'Andrey', N'123321')
INSERT [dbo].[Usuario] ([id_usuario], [nombre_usuario], [contraseña]) VALUES (3, N'Alejandro', N'112233')
INSERT [dbo].[Usuario] ([id_usuario], [nombre_usuario], [contraseña]) VALUES (4, N'Laura', N'123123')
INSERT [dbo].[Usuario] ([id_usuario], [nombre_usuario], [contraseña]) VALUES (5, N'Ivannia', N'654321')
SET IDENTITY_INSERT [dbo].[Usuario] OFF
GO
SET IDENTITY_INSERT [dbo].[Vacuna] ON 

INSERT [dbo].[Vacuna] ([id_vacuna], [id_especie], [precio], [nombre]) VALUES (1, 1, 4657, N'Triple         ')
INSERT [dbo].[Vacuna] ([id_vacuna], [id_especie], [precio], [nombre]) VALUES (2, 2, 5500, N'Trivalente     ')
INSERT [dbo].[Vacuna] ([id_vacuna], [id_especie], [precio], [nombre]) VALUES (5, 1, 6500, N'Parvovirus     ')
INSERT [dbo].[Vacuna] ([id_vacuna], [id_especie], [precio], [nombre]) VALUES (6, 2, 4567, N'Leucemia felina')
INSERT [dbo].[Vacuna] ([id_vacuna], [id_especie], [precio], [nombre]) VALUES (8, 2, 9000, N'Rabia          ')
INSERT [dbo].[Vacuna] ([id_vacuna], [id_especie], [precio], [nombre]) VALUES (15, 1, 8765, N'Rabia          ')
SET IDENTITY_INSERT [dbo].[Vacuna] OFF
GO
ALTER TABLE [dbo].[Cita]  WITH CHECK ADD  CONSTRAINT [FK_Cita_Condicion] FOREIGN KEY([id_condicion])
REFERENCES [dbo].[Condicion] ([id_condicion])
GO
ALTER TABLE [dbo].[Cita] CHECK CONSTRAINT [FK_Cita_Condicion]
GO
ALTER TABLE [dbo].[Cita]  WITH CHECK ADD  CONSTRAINT [FK_Cita_Paciente] FOREIGN KEY([id_Paciente])
REFERENCES [dbo].[Paciente] ([id_paciente])
GO
ALTER TABLE [dbo].[Cita] CHECK CONSTRAINT [FK_Cita_Paciente]
GO
ALTER TABLE [dbo].[Cita_Actitud]  WITH CHECK ADD  CONSTRAINT [FK_Cita_Actitud_Actitud] FOREIGN KEY([id_actitud])
REFERENCES [dbo].[Actitud] ([id_actitud])
GO
ALTER TABLE [dbo].[Cita_Actitud] CHECK CONSTRAINT [FK_Cita_Actitud_Actitud]
GO
ALTER TABLE [dbo].[Cita_Actitud]  WITH CHECK ADD  CONSTRAINT [FK_Cita_Actitud_Cita] FOREIGN KEY([id_cita])
REFERENCES [dbo].[Cita] ([id_cita])
GO
ALTER TABLE [dbo].[Cita_Actitud] CHECK CONSTRAINT [FK_Cita_Actitud_Cita]
GO
ALTER TABLE [dbo].[Cita_Evaluacion]  WITH CHECK ADD  CONSTRAINT [FK_Cita_Evaluacion_Cita] FOREIGN KEY([id_cita])
REFERENCES [dbo].[Cita] ([id_cita])
GO
ALTER TABLE [dbo].[Cita_Evaluacion] CHECK CONSTRAINT [FK_Cita_Evaluacion_Cita]
GO
ALTER TABLE [dbo].[Cita_Evaluacion]  WITH CHECK ADD  CONSTRAINT [FK_Cita_Evaluacion_Evaluacion] FOREIGN KEY([id_evaluacion])
REFERENCES [dbo].[Evaluacion] ([id_evaluacion])
GO
ALTER TABLE [dbo].[Cita_Evaluacion] CHECK CONSTRAINT [FK_Cita_Evaluacion_Evaluacion]
GO
ALTER TABLE [dbo].[Cita_motivo]  WITH CHECK ADD  CONSTRAINT [FK_Cita_motivo_Cita] FOREIGN KEY([id_cita])
REFERENCES [dbo].[Cita] ([id_cita])
GO
ALTER TABLE [dbo].[Cita_motivo] CHECK CONSTRAINT [FK_Cita_motivo_Cita]
GO
ALTER TABLE [dbo].[Cita_motivo]  WITH CHECK ADD  CONSTRAINT [FK_Cita_motivo_Motivo] FOREIGN KEY([id_motivo])
REFERENCES [dbo].[Motivo] ([id_motivo])
GO
ALTER TABLE [dbo].[Cita_motivo] CHECK CONSTRAINT [FK_Cita_motivo_Motivo]
GO
ALTER TABLE [dbo].[Cita_motivo]  WITH CHECK ADD  CONSTRAINT [FK_Cita_motivo_Vacuna] FOREIGN KEY([id_vacuna])
REFERENCES [dbo].[Vacuna] ([id_vacuna])
GO
ALTER TABLE [dbo].[Cita_motivo] CHECK CONSTRAINT [FK_Cita_motivo_Vacuna]
GO
ALTER TABLE [dbo].[Cita_PruebaLaboratorio]  WITH CHECK ADD  CONSTRAINT [FK_Cita_pruebaLaboratorio_Cita] FOREIGN KEY([id_cita])
REFERENCES [dbo].[Cita] ([id_cita])
GO
ALTER TABLE [dbo].[Cita_PruebaLaboratorio] CHECK CONSTRAINT [FK_Cita_pruebaLaboratorio_Cita]
GO
ALTER TABLE [dbo].[Cita_PruebaLaboratorio]  WITH CHECK ADD  CONSTRAINT [FK_Cita_pruebaLaboratorio_PruebaLaboratorio] FOREIGN KEY([id_pruebaLaboratorio])
REFERENCES [dbo].[PruebaLaboratorio] ([id_prueba])
GO
ALTER TABLE [dbo].[Cita_PruebaLaboratorio] CHECK CONSTRAINT [FK_Cita_pruebaLaboratorio_PruebaLaboratorio]
GO
ALTER TABLE [dbo].[Cita_PruebaLaboratorio]  WITH CHECK ADD  CONSTRAINT [FK_Cita_PruebaLaboratorio_SubCategoriaPrueba] FOREIGN KEY([id_subCategoria])
REFERENCES [dbo].[SubCategoriaPrueba] ([id_subCategoria])
GO
ALTER TABLE [dbo].[Cita_PruebaLaboratorio] CHECK CONSTRAINT [FK_Cita_PruebaLaboratorio_SubCategoriaPrueba]
GO
ALTER TABLE [dbo].[Evaluacion]  WITH CHECK ADD  CONSTRAINT [FK_Evaluacion_Estado] FOREIGN KEY([id_estado])
REFERENCES [dbo].[Estado] ([id_estado])
GO
ALTER TABLE [dbo].[Evaluacion] CHECK CONSTRAINT [FK_Evaluacion_Estado]
GO
ALTER TABLE [dbo].[Evaluacion]  WITH CHECK ADD  CONSTRAINT [FK_Evaluacion_Tipo_evaluacion] FOREIGN KEY([id_tipo_evaluacion])
REFERENCES [dbo].[Tipo_evaluacion] ([id_tipo_evaluacion])
GO
ALTER TABLE [dbo].[Evaluacion] CHECK CONSTRAINT [FK_Evaluacion_Tipo_evaluacion]
GO
ALTER TABLE [dbo].[Paciente]  WITH CHECK ADD  CONSTRAINT [FK_Paciente_Dueño] FOREIGN KEY([cedula_dueño])
REFERENCES [dbo].[Dueño] ([cedula])
GO
ALTER TABLE [dbo].[Paciente] CHECK CONSTRAINT [FK_Paciente_Dueño]
GO
ALTER TABLE [dbo].[Paciente]  WITH CHECK ADD  CONSTRAINT [FK_Paciente_Especies] FOREIGN KEY([id_especie])
REFERENCES [dbo].[Especie] ([id_especie])
GO
ALTER TABLE [dbo].[Paciente] CHECK CONSTRAINT [FK_Paciente_Especies]
GO
ALTER TABLE [dbo].[Paciente]  WITH CHECK ADD  CONSTRAINT [FK_Paciente_Raza] FOREIGN KEY([id_raza])
REFERENCES [dbo].[Raza] ([id_raza])
GO
ALTER TABLE [dbo].[Paciente] CHECK CONSTRAINT [FK_Paciente_Raza]
GO
ALTER TABLE [dbo].[Raza]  WITH CHECK ADD  CONSTRAINT [FK_Razas_Especies] FOREIGN KEY([id_especie])
REFERENCES [dbo].[Especie] ([id_especie])
GO
ALTER TABLE [dbo].[Raza] CHECK CONSTRAINT [FK_Razas_Especies]
GO
ALTER TABLE [dbo].[SubCategoriaPrueba]  WITH CHECK ADD  CONSTRAINT [FK_SubCategoriaPrueba_PruebaLaboratorio] FOREIGN KEY([id_prueba])
REFERENCES [dbo].[PruebaLaboratorio] ([id_prueba])
GO
ALTER TABLE [dbo].[SubCategoriaPrueba] CHECK CONSTRAINT [FK_SubCategoriaPrueba_PruebaLaboratorio]
GO
ALTER TABLE [dbo].[Vacuna]  WITH CHECK ADD  CONSTRAINT [FK_Vacuna_Especies] FOREIGN KEY([id_especie])
REFERENCES [dbo].[Especie] ([id_especie])
GO
ALTER TABLE [dbo].[Vacuna] CHECK CONSTRAINT [FK_Vacuna_Especies]
GO
USE [master]
GO
ALTER DATABASE [ProyectoVeterinaria] SET  READ_WRITE 
GO
