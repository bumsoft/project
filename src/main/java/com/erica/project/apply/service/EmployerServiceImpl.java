package com.erica.project.apply.service;

import com.erica.project.User.domain.Employee;
import com.erica.project.apply.domain.Application_State;
import com.erica.project.apply.domain.Job_Posting;
import com.erica.project.apply.dto.Job_PostingDto;
import com.erica.project.apply.repository.Job_PostingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployerServiceImpl implements EmployerService{

    private final Job_PostingRepository jobPostingRepository;
    @Override
    public Job_Posting saveJobPost(Job_PostingDto job_postingDto)
    {
        Job_Posting job_posting = new Job_Posting(job_postingDto.getEmployer(), job_postingDto.getEmployer_compname(), job_postingDto.getLocation(),
                job_postingDto.getJob_Posting_salaryPerTime(),job_postingDto.getJob_Posting_workdate(),job_postingDto.getJob_Posting_worktime());

        return jobPostingRepository.save(job_posting);
    }


    @Override
    public List<Employee> getApplicants(int Job_Posting_id)
    {
        return null;
    }

    @Override
    public Employee getApplicantsInfo(int Employee_id)
    {
        return null;
    }

    @Override
    public Application_State AcceptOrReject(int Application_id, boolean accept)
    {
        return null;
    }

    @Override
    public Employee giveEmployeeLevel(int Employee_id)
    {
        return null;
    }
}
