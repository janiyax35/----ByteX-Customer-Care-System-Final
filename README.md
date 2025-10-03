<!-- Animated Header Banner -->
<div align="center">
  <img src="https://capsule-render.vercel.app/api?type=waving&color=0:1c1c22,100:2a2a32&height=200&section=header&text=ByteX%20Customer%20Care%20System&fontSize=50&fontColor=ffffff&animation=fadeIn&fontAlignY=38&desc=Streamlined%20IT%20Support%20Management" width="100%"/>

  <!-- Typing SVG Effect -->
  <img src="https://readme-typing-svg.demolab.com?font=Share+Tech+Mono&duration=3000&pause=1000&color=00EEFF&center=true&vCenter=true&multiline=false&width=600&height=60&lines=Advanced+Customer+Support+Management;Efficient+Inventory+Tracking;Real-time+Ticket+Resolution;Comprehensive+Repair+Management" alt="Typing SVG"/>
</div>

<!-- Badges Section -->
<p align="center">
  <img src="https://img.shields.io/badge/Java-17-orange?style=for-the-badge&logo=java&logoColor=white&labelColor=2a2a32" alt="Java 17"/>
  <img src="https://img.shields.io/badge/Spring%20Boot-3.5.4-brightgreen?style=for-the-badge&logo=springboot&logoColor=white&labelColor=2a2a32" alt="Spring Boot"/>
  <img src="https://img.shields.io/badge/MySQL-8.0-blue?style=for-the-badge&logo=mysql&logoColor=white&labelColor=2a2a32" alt="MySQL"/>
  <img src="https://img.shields.io/badge/Thymeleaf-Latest-green?style=for-the-badge&logo=thymeleaf&logoColor=white&labelColor=2a2a32" alt="Thymeleaf"/>
  <img src="https://img.shields.io/badge/JPA-Latest-yellow?style=for-the-badge&logo=hibernate&logoColor=white&labelColor=2a2a32" alt="JPA"/>
  <br/>
  <img src="https://img.shields.io/badge/Status-In%20Development-blueviolet?style=for-the-badge&labelColor=2a2a32" alt="Status"/>
  <img src="https://img.shields.io/badge/License-MIT-yellow?style=for-the-badge&labelColor=2a2a32" alt="License"/>
</p>

<!-- Repository Line Decoration -->
<p align="center">
  <img src="https://i.imgur.com/waxVImv.png" width="100%" height="4px" alt="Line"/>
</p>

## 📋 Table of Contents

- [Overview](#-overview)
- [Key Features](#-key-features)
- [System Architecture](#-system-architecture)
- [Technology Stack](#-technology-stack)
- [Installation Guide](#-installation-guide)
- [Usage Instructions](#-usage-instructions)
- [Screenshots & Demo](#-screenshots--demo)
- [System Requirements](#-system-requirements)
- [Database Schema](#-database-schema)
- [Contributing](#-contributing)
- [License](#-license)
- [Contact](#-contact)

<p align="center">
  <img src="https://i.imgur.com/waxVImv.png" width="100%" height="2px" alt="Line"/>
</p>

## 🔍 Overview

**ByteX Customer Care System** is a comprehensive support management solution designed to streamline IT customer support operations. The system efficiently handles customer tickets, manages repairs, tracks inventory, and orchestrates the complete support workflow from initial customer contact through resolution.

Developed for IT support departments, the system connects customers, support staff, technicians, and management in a single integrated platform, ensuring transparency and accountability at every stage of the support process.

<div align="center">
  <table>
    <tr>
      <td align="center">
        <img src="https://img.shields.io/badge/Role%20Based%20Access-2a2a32?style=for-the-badge&logo=shield&logoColor=white" alt="Role Based Access"/>
        <br/>Role-Based Access Control
      </td>
      <td align="center">
        <img src="https://img.shields.io/badge/Ticket%20Tracking-2a2a32?style=for-the-badge&logo=task&logoColor=white" alt="Ticket Tracking"/>
        <br/>Advanced Ticket Management
      </td>
      <td align="center">
        <img src="https://img.shields.io/badge/Inventory%20System-2a2a32?style=for-the-badge&logo=inventory&logoColor=white" alt="Inventory System"/>
        <br/>Inventory Management
      </td>
    </tr>
  </table>
</div>

## ✨ Key Features

<div align="center">
  <img src="https://readme-typing-svg.demolab.com?font=Share+Tech+Mono&size=18&duration=2000&pause=1000&color=00EEFF&center=true&vCenter=true&multiline=true&repeat=false&width=650&height=30&lines=System+Features+Overview" alt="System Features"/>
</div>

- **📝 Ticket Management System**
  - Multi-stage ticket workflow (OPEN → IN_PROGRESS → PENDING → CLOSED)
  - Priority-based routing (LOW, MEDIUM, HIGH)
  - Role-based ticket assignment

- **👥 User Role Management**
  - Six user roles with specific permissions:
    - 👑 Admin: System oversight and configuration
    - 👨‍💼 Staff: First-line customer support
    - 👨‍🔧 Technician: Hardware and technical repairs
    - 🧑‍💼 Product Manager: Parts and inventory coordination
    - 🏭 Warehouse Manager: Stock and supply management
    - 👤 Customer: Service requests and support access

- **🔧 Repair Management**
  - Detailed repair tracking and documentation
  - Technician assignment and workload management
  - Parts requisition integration

- **📦 Inventory Control**
  - Real-time stock monitoring
  - Automated low-stock alerts
  - Parts request workflow

- **🏢 Supplier Management**
  - Supplier relationship management
  - Purchase order creation and tracking
  - Delivery management

- **📊 Reporting & Analytics**
  - Comprehensive activity logging
  - Performance metrics tracking
  - Audit trail for all system activities

## 🏗️ System Architecture

The ByteX Customer Care System follows a modern three-tier architecture pattern:

<div align="center">
  <table>
    <tr>
      <td align="center" style="background-color:#2a2a32;">
        <b>Presentation Layer</b><br/>
        Thymeleaf Templates
      </td>
    </tr>
    <tr>
      <td align="center" style="background-color:#1c1c22;">
        <b>Application Layer</b><br/>
        Spring Boot Controllers & Services
      </td>
    </tr>
    <tr>
      <td align="center" style="background-color:#131316;">
        <b>Data Access Layer</b><br/>
        Spring Data JPA & MySQL
      </td>
    </tr>
  </table>
</div>

## 🛠️ Technology Stack

<div align="center">
  <img src="https://readme-typing-svg.demolab.com?font=Share+Tech+Mono&size=18&duration=2000&pause=1000&color=00EEFF&center=true&vCenter=true&multiline=true&repeat=false&width=650&height=30&lines=Complete+Technology+Stack" alt="Technology Stack"/>
</div>

### Backend
- **Java 17** - Core programming language
- **Spring Boot 3.5.4** - Application framework
- **Spring Data JPA** - Data persistence
- **Hibernate** - ORM mapping
- **MySQL 8.0** - Database

### Frontend
- **Thymeleaf** - Server-side Java template engine
- **HTML5/CSS3** - Frontend markup and styling
- **Bootstrap** - Responsive design framework
- **JavaScript** - Client-side scripting

### Development Tools
- **Maven** - Dependency management
- **Git** - Version control
- **JUnit** - Testing framework

## 🚀 Installation Guide

<div align="center">
  <img src="https://readme-typing-svg.demolab.com?font=Share+Tech+Mono&size=18&duration=2000&pause=1000&color=00EEFF&center=true&vCenter=true&multiline=true&repeat=false&width=650&height=30&lines=Setup+Instructions" alt="Setup Instructions"/>
</div>

### Prerequisites
- Java JDK 17+
- Maven 3.6+
- MySQL 8.0+
- Git (optional)

### Step 1: Clone the Repository
```bash
git clone https://github.com/janiyax35/----ByteX-Customer-Care-System-Final.git
cd ----ByteX-Customer-Care-System-Final
```

### Step 2: Configure Database
- Create a MySQL database (or use existing one):
```bash
mysql -u root -p
CREATE DATABASE v2_05bytex_database;
exit;
```
- Update database configuration in `src/main/resources/application.properties` if needed:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/v2_05bytex_database?createDatabaseIfNotExist=true
spring.datasource.username=root
spring.datasource.password=root
```

### Step 3: Build and Run
```bash
mvn clean install
mvn spring-boot:run
```

### Step 4: Access the Application
Open your browser and navigate to:
```
http://localhost:8080
```

## 💻 Usage Instructions

<div align="center">
  <img src="https://readme-typing-svg.demolab.com?font=Share+Tech+Mono&size=18&duration=2000&pause=1000&color=00EEFF&center=true&vCenter=true&multiline=true&repeat=false&width=650&height=30&lines=User+Guide" alt="User Guide"/>
</div>

### User Login
- Access the login page and enter your credentials
- Default admin credentials:
  - Username: `admin`
  - Password: `admin123`

### Customer Journey
1. **Create a Support Ticket**
   - Navigate to "New Ticket"
   - Fill in details and set priority
   - Upload attachments if needed

2. **Track Ticket Status**
   - Visit "My Tickets" dashboard
   - View real-time status updates
   - Respond to staff inquiries

### Staff Operations
1. **Manage Tickets**
   - Process incoming tickets
   - Assign to technicians
   - Communicate with customers

2. **Handle Escalations**
   - Escalate complex issues
   - Coordinate with technical team

### Technician Workflow
1. **Repair Management**
   - Access assigned repair tickets
   - Document diagnosis and solutions
   - Request parts when needed

2. **Update Repair Status**
   - Track repair progress
   - Document parts used
   - Complete repair documentation

### Inventory Management
1. **Track Parts**
   - Monitor inventory levels
   - Receive low-stock alerts
   - Process part requests

2. **Purchase Management**
   - Create purchase orders
   - Track supplier deliveries
   - Update inventory on receipt

## 📸 Screenshots & Demo

<div align="center">
  <img src="https://readme-typing-svg.demolab.com?font=Share+Tech+Mono&size=18&duration=2000&pause=1000&color=00EEFF&center=true&vCenter=true&multiline=true&repeat=false&width=650&height=30&lines=System+Interface+Previews" alt="Interface Previews"/>
</div>

<div align="center">
  <i>Screenshots will be added as development progresses.</i>
  <br/><br/>
  <img src="https://github.com/janiyax35/----ByteX-Customer-Care-System-Final/blob/885fdd79340e39818a811adc7ff36eb2c4cd337e/assets/01.png" alt="Dashboard Preview" width="80%"/>
  <p><i>Login Interface - Coming Soon</i></p>
  
  <img src="https://github.com/janiyax35/----ByteX-Customer-Care-System-Final/blob/885fdd79340e39818a811adc7ff36eb2c4cd337e/assets/02.png" alt="Ticket System Preview" width="80%"/>
  <p><i>Ticket Management System - Coming Soon</i></p>
  
  <img src="https://github.com/janiyax35/----ByteX-Customer-Care-System-Final/blob/885fdd79340e39818a811adc7ff36eb2c4cd337e/assets/03.png" alt="Inventory Module Preview" width="80%"/>
  <p><i>Profile Management Module - Coming Soon</i></p>
</div>

## 💾 System Requirements

<div align="center">
  <img src="https://readme-typing-svg.demolab.com?font=Share+Tech+Mono&size=18&duration=2000&pause=1000&color=00EEFF&center=true&vCenter=true&multiline=true&repeat=false&width=650&height=30&lines=Hardware+and+Software+Requirements" alt="System Requirements"/>
</div>

### Hardware Requirements
- **Processor**: Dual-core 2GHz or higher
- **RAM**: 4GB minimum, 8GB recommended
- **Storage**: 10GB free space for application and database

### Software Requirements
- **Operating System**: Windows 10/11, macOS 10.15+, or Linux
- **Database**: MySQL 8.0+
- **Java Runtime**: JDK 17 or higher
- **Web Browser**: Chrome 80+, Firefox 72+, Safari 14+, Edge 80+
- **Server Environment**: Tomcat (embedded with Spring Boot)

### Network Requirements
- **Bandwidth**: 1 Mbps per concurrent user
- **Ports**: 8080 (HTTP), 3306 (MySQL)

## 📊 Database Schema

<div align="center">
  <img src="https://readme-typing-svg.demolab.com?font=Share+Tech+Mono&size=18&duration=2000&pause=1000&color=00EEFF&center=true&vCenter=true&multiline=true&repeat=false&width=650&height=30&lines=Database+Structure+Overview" alt="Database Structure"/>
</div>

The ByteX Customer Care System uses a normalized relational database with the following key tables:

- **Roles & Users**: User authentication and authorization
- **Tickets**: Customer support requests
- **Repairs**: Technical repair records
- **Parts & Inventory**: Parts tracking and stock management
- **Suppliers & Purchase Orders**: Supply chain management
- **Activity Logs**: System auditing and monitoring

<div align="center">
  <i>Entity Relationship Diagram will be added in future updates.</i>
</div>

## 🤝 Contributing

<div align="center">
  <img src="https://readme-typing-svg.demolab.com?font=Share+Tech+Mono&size=18&duration=2000&pause=1000&color=00EEFF&center=true&vCenter=true&multiline=true&repeat=false&width=650&height=30&lines=Contribution+Guidelines" alt="Contribution Guidelines"/>
</div>

We welcome contributions to the ByteX Customer Care System! To contribute:

1. **Fork the Repository**: Create your own fork of the project
2. **Create a Feature Branch**: `git checkout -b feature/amazing-feature`
3. **Make Changes**: Implement your changes or fixes
4. **Run Tests**: Ensure all tests pass
5. **Commit Changes**: `git commit -m 'Add some amazing feature'`
6. **Push to Branch**: `git push origin feature/amazing-feature`
7. **Open a Pull Request**: Submit a PR to the main repository

### Code Style Guidelines
- Follow Java coding conventions
- Write clear, documented code
- Include appropriate tests for new features

## 📄 License

This project is licensed under the MIT License - see the LICENSE file for details.

## 📬 Contact

<div align="center">
  <img src="https://readme-typing-svg.demolab.com?font=Share+Tech+Mono&size=18&duration=2000&pause=1000&color=00EEFF&center=true&vCenter=true&multiline=true&repeat=false&width=650&height=30&lines=Get+In+Touch" alt="Contact Information"/>
</div>

<div align="center">
  <a href="https://github.com/janiyax35">
    <img src="https://img.shields.io/badge/GitHub-janiyax35-00EEFF?style=for-the-badge&logo=github&logoColor=white&labelColor=2a2a32" alt="GitHub"/>
  </a>
  <br/>
  <a href="mailto:janithmihijaya123@gmail.com">
    <img src="https://img.shields.io/badge/Email-Contact%20Developer-00EEFF?style=for-the-badge&logo=gmail&logoColor=white&labelColor=2a2a32" alt="Email"/>
  </a>
</div>

<!-- Matrix Animation Footer -->
<div align="center">
  <img src="https://capsule-render.vercel.app/api?type=waving&color=0:2a2a32,100:1c1c22&height=120&section=footer&text=ByteX%20Technologies&fontSize=30&fontColor=ffffff&animation=fadeIn&fontAlignY=70" width="100%"/>
  
  <!-- Typing SVG Effect for Footer -->
  <img src="https://readme-typing-svg.demolab.com?font=Share+Tech+Mono&size=14&duration=3000&pause=1000&color=00EEFF&center=true&vCenter=true&multiline=true&repeat=true&width=500&height=30&lines=Building+better+support+systems%2C+one+ticket+at+a+time." alt="Motto"/>
</div>
