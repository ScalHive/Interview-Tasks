All questions and discussion in issues of this project.


## Introduction

1. Solutions could be written on your choose in English (preferred) or Ukrainian language.
2. Use your personal GitHub account to fork this project and push your solution to it (current branch and subdirectory).
3. Send link to your fork project with solution.
4. Task 1 and Task 2 are students practice or trainee level.
5. Task 3 is for job offer candidates (Task 1 and Task 2 are required too ).
6. All solutions should be in the same forked project with good code style, comments and SOLUTION.md description.



## The priorities for solutions are:
  1) being correct
  2) being readable and extensible




### Task-1

List of used tools:
- VirtualBox
- Vagrant
- Centos7.4
- Docker
- Ansible
- Git
- Web browser

What should you do:
1. Make VM using Vagrant (v2.0.1) configuration file should be in root directory (OS: CentOS 7.4)
2. Install required tools and docker (v17.09.1-ce) in VM
3. Fork git repo https://github.com/dataengi/crm-seed and clone one to VM
4. Discover project structure https://github.com/dataengi/crm-seed/wiki
5. Deploy project in presentation mode (docker-compose.yml)
6. Push your result to your fork of https://github.com/dataengi/crm-seed
7. Add link to your fork in SOLUTION.md

To discuss:
- VM hardware limits
- container limits and policy
- security risks


### Task-2
What should you do:
- Automate Task-1 from step 2 (Install required tools and docker (v17.09.1-ce) in VM)
- Create deployment play-books for installation required tools and applications
that needed for running CRM server in Docker. Use ansible (v2.4.2.0).
- As result, your virtual machine will run as CRM server.
All ansible code should be in subdirectory ./ansible of project


### Task-3
What should you do:
- Install and configure [Ansible AWX](https://github.com/ansible/awx) 
- Configure AWX to be able to run created on Task-2 yours ansible playbooks from AWX Web interface.
- All steps of configuration must be documented in your project.
- Add all used automated deploy scripts in this folder, 
so we could reproduce your solution according to SOLUTION.md instructions. 

## Recommended literature
1. https://devopsbootcamp.osuosl.org/
2. https://www.vagrantup.com/downloads.html
3. http://docs.ansible.com/ansible/latest/playbooks_best_practices.html
4. https://docs.docker.com/engine/installation/linux/docker-ce/centos/#upgrade-docker-ce-1
5. https://portainer.io/
6. http://docs.ansible.com/ansible/latest/playbooks_best_practices.html#directory-layout
7. [GitLab University](https://docs.gitlab.com/ee/university/)
