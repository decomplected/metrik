package fourkeymetrics.resource

import fourkeymetrics.repository.pipeline.Pipeline
import fourkeymetrics.service.DeploymentFrequencyService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

data class DeploymentFrequencyResponse(val deploymentCount: Int)

@RestController
class DeploymentFrequencyResource {
    @Autowired
    private lateinit var deploymentFrequencyService: DeploymentFrequencyService

    @Autowired
    private lateinit var pipeline: Pipeline

    @GetMapping("/api/deployment-frequency")
    fun getDeploymentCount(@RequestParam dashboardId: String,
                           @RequestParam pipelineId: String,
                           @RequestParam startTimestamp: Long,
                           @RequestParam endTimestamp: Long,
                           @RequestParam targetStage: String): ResponseEntity<DeploymentFrequencyResponse> {
        if (isInvalidParameters(dashboardId, pipelineId, endTimestamp, startTimestamp, targetStage)) {
            return ResponseEntity.badRequest().build()
        }

        val deploymentCount = deploymentFrequencyService.getDeploymentCount(pipelineId, targetStage,
            startTimestamp, endTimestamp)

        return ResponseEntity.ok(DeploymentFrequencyResponse(deploymentCount))
    }

    private fun isInvalidParameters(dashboardId: String, pipelineId: String, endTimestamp: Long,
                                    startTimestamp: Long,
                                    targetStage: String): Boolean {
        return startTimestamp > endTimestamp ||
            !pipeline.hasPipeline(dashboardId, pipelineId) ||
            !pipeline.hasStageInTimeRange(pipelineId, targetStage, startTimestamp, endTimestamp)
    }
}
