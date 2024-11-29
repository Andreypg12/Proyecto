USE [master]
GO
/****** Object:  Database [ProyectoVeterinaria]    Script Date: 28/11/2024 21:53:33 ******/
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
/****** Object:  User [UserProject]    Script Date: 28/11/2024 21:53:33 ******/
CREATE USER [UserProject] WITHOUT LOGIN WITH DEFAULT_SCHEMA=[db_accessadmin]
GO
/****** Object:  Table [dbo].[Actitud]    Script Date: 28/11/2024 21:53:34 ******/
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
/****** Object:  Table [dbo].[Cita]    Script Date: 28/11/2024 21:53:34 ******/
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
/****** Object:  Table [dbo].[Cita_Actitud]    Script Date: 28/11/2024 21:53:34 ******/
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
/****** Object:  Table [dbo].[Cita_Evaluacion]    Script Date: 28/11/2024 21:53:34 ******/
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
/****** Object:  Table [dbo].[Cita_motivo]    Script Date: 28/11/2024 21:53:34 ******/
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
/****** Object:  Table [dbo].[Cita_PruebaLaboratorio]    Script Date: 28/11/2024 21:53:34 ******/
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
/****** Object:  Table [dbo].[Condicion]    Script Date: 28/11/2024 21:53:34 ******/
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
/****** Object:  Table [dbo].[Dueño]    Script Date: 28/11/2024 21:53:34 ******/
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
/****** Object:  Table [dbo].[Especie]    Script Date: 28/11/2024 21:53:34 ******/
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
/****** Object:  Table [dbo].[Estado]    Script Date: 28/11/2024 21:53:34 ******/
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
/****** Object:  Table [dbo].[Evaluacion]    Script Date: 28/11/2024 21:53:34 ******/
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
/****** Object:  Table [dbo].[Motivo]    Script Date: 28/11/2024 21:53:34 ******/
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
/****** Object:  Table [dbo].[Paciente]    Script Date: 28/11/2024 21:53:34 ******/
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
/****** Object:  Table [dbo].[PruebaLaboratorio]    Script Date: 28/11/2024 21:53:34 ******/
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
/****** Object:  Table [dbo].[Raza]    Script Date: 28/11/2024 21:53:34 ******/
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
/****** Object:  Table [dbo].[SubCategoriaPrueba]    Script Date: 28/11/2024 21:53:34 ******/
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
/****** Object:  Table [dbo].[Tipo_evaluacion]    Script Date: 28/11/2024 21:53:34 ******/
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
/****** Object:  Table [dbo].[Usuario]    Script Date: 28/11/2024 21:53:34 ******/
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
/****** Object:  Table [dbo].[Vacuna]    Script Date: 28/11/2024 21:53:34 ******/
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
