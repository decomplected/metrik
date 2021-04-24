package fourkeymetrics.project.service.factory

import fourkeymetrics.common.model.Build
import fourkeymetrics.project.controller.applicationservice.SyncProgress
import fourkeymetrics.project.model.Pipeline
import fourkeymetrics.project.service.PipelineService
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service("noopPipelineService")
class NoopPipelineService : PipelineService {
    private var logger = LoggerFactory.getLogger(this.javaClass.name)

    override fun syncBuilds(pipeline: Pipeline): List<Build> {
        logger.info("Noop implementation")
        return emptyList()
    }

    override fun syncBuildsProgressively(pipeline: Pipeline, emitCb: (SyncProgress) -> Unit): List<Build> {
        logger.info("Noop implementation")
        return emptyList()
    }

    override fun verifyPipelineConfiguration(pipeline: Pipeline) {
        logger.info("Noop implementation")
    }

    override fun getStagesSortedByName(pipelineId: String): List<String> {
        logger.info("Noop implementation")
        return emptyList()
    }
}
