Please read this!

Title for this issue is a **`MANDATORY`** to follow this format

  [incident] Title of incident on j M Y H:i
  
eg:

  [incident]Bad Gateway Error on 08 Feb 2020 16:00
  
Please remove this notice.
------

# Incident Response Report Template

## Information Required


|Item             ||
|----------------------------------------------------|---------------------------------------|
|**Reference Number**                                | *(git2u group/project with issue ID)* |
|**Company Name**                                    | **Razer Merchant Services** |
|**Incident Place**                                  | *Mandatory* |
|**Name and title of<br>person making the<br>report**| *Mandatory* |
|**Applicable Law and Regulations**                  | *To be filled in for breaches of laws and regulations.<br>For breaches of laws and regulations, texts of governing laws and regulations should be attached. Please consult Legal & Regulatory Compliance.<br>`Whether or not the case should be reported to local authorities.`* |
|**Date reported to the<br>Senior Management<br>and the Chief Legal<br>& Compliance<br>Officer of Razer Inc.**| *Mandatory* |
|**Period of Incident**                              | *Mandatory* |
|**Incident Amount**                                 | *To be filled in if applicable* |
|**How did you find out<br>about the incident?<br>(With date)** | *Mandatory* |
|**Outline of Incident**                             | *Mandatory* <br><br> Please describe events in a chronological order with dates and add<br>an explanation to abbreviations of organizations names and others.<br>The following information must be reported:<br> - findings and recommendations;<br> - root cause analysis;<br> - if some controls were in place to prevent related events<br> before the occurrence or discovery even if they are<br> insufficient;<br> - remediation and improvement plans.
|**Status of the<br>investigation on<br>Incident**   | *Mandatory* <br><br> The following points must be mentioned:<br> - whether or not relevant risks were pointed out in the past (e.g: by internal audit);<br> - risk and possibility of similar or repeated incident.
|**Actions taken after<br>Incident**                 | *Mandatory*<br><br> 1) Fraud : *Status of police report (if any) must be reported*<br><br> 2) Cases involving customers : *Action taken must be reported.*<br><br> 3) Company losses and fines due to failure and negligence of third party<br> Whether or not the Company sought for indemnification or recovery<br>and the status.
|**Root Cause Analysis**                             | *Mandaroty* <br><br> Please go to root causes |
|**Measures of<br>Recurrence<br>Prevention/<br>Lessons Learned** | *Mandatory* <br><br> Please explain clearly the effectiveness of prevent<br>recurrence and limitations if any
|**Personnel Penalty<br><br>For persons causing<br>the Incident** | To be filled in for frauds, breaches of laws and regulations, cases<br>causing company losses, information leakage and incidents which<br>have the potential of causing significant damage to the Company's<br>reputation and credibility.<br> (including when the Senior Management decides not to impose a<br>penalty)
|**Comments by<br>Regulatory<br>Compliance and/or<br>Risk Management** | *Mandatory*<br><br> Regulatory Compliance and/or Risk Management are to:<br> 1) Assess if the case is an isolated error or suggests lack of controls<br>and to comment or make recommendations;<br> 2) Assess the possibility of similar incidents and comment or make<br> recommendations; and <br> 3) evaluate the reasonableness, sufficiency and effectiveness of<br>investigation, actions taken after incidents, cause analysis and<br> measures of prevention and personnel penalty and to comment or<br>make recommendations.
|**Reports to the<br> Senior Management<br>and the Chief Legal<br> & Compliance <br> Officer of Razer Inc. <br> and their <br> instructions** | *Mandatory*<br><br> Reporting method and their instructions should be reported

## Infra Team Checklist

*Network*  

- [ ] SSL Cert
- [ ] Domain Name (Akamain, CloudFlare)
- [ ] Load Balancer

*Server*

- [ ] Server status *(CPU, Memory, Storage, Network)*
- [ ] Glogger
- [ ] System
- [ ] Service

*Database*

- [ ] Database Status *(Replication Delay, CPU, Memory, database connection)*

## Programmer Team Checklist

- [ ] New Relic APM *(Response Time, Throughput, PHP, Database, Web External)*
- [ ] Queue Worker in Gearman Worker on Payment Server
- [ ] Latest Deployment
- [ ] Source Code or Application Log

## Ops Team Checklist

- [ ] Channel affected details *(How many channels affected, Online or Offline)*
- [ ] Announcement for unexpected downtime for channel affected and inform VIP merchant

/assign me  
/label ~"Type::Incident" ~"Type::Documentation"