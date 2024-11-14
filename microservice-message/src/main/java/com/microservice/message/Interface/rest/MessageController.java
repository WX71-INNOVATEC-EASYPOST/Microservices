package com.microservice.message.Interface.rest;

import com.microservice.message.Interface.rest.resources.CreateMessageResource;
import com.microservice.message.Interface.rest.resources.MessageResource;
import com.microservice.message.Interface.rest.transform.CreateMessageCommandFromResourceFromAssembler;
import com.microservice.message.Interface.rest.transform.MessageResourceFromEntityAssembler;
import com.microservice.message.domain.model.entity.Message;
import com.microservice.message.domain.model.queries.GetAllMessageByRecipientAndSenderIdQuery;
import com.microservice.message.domain.model.queries.GetMessageByIdQuery;
import com.microservice.message.domain.services.MessageCommandService;
import com.microservice.message.domain.services.MessageQueryService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping(value = "api/v1/message", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Message", description = "Message Management Endpoints")
public class MessageController {
    private final MessageQueryService messageQueryService;
    private final MessageCommandService messageCommandService;
    public MessageController(MessageQueryService messageQueryService, MessageCommandService messageCommandService) {
        this.messageQueryService = messageQueryService;
        this.messageCommandService = messageCommandService;
    }

    @PostMapping
    public ResponseEntity<MessageResource> createMessage(@RequestBody CreateMessageResource createMessageResource) {
        Optional<Message> messageSource = messageCommandService
                .handle(CreateMessageCommandFromResourceFromAssembler.toCommandFromResource(createMessageResource));
        return messageSource.map(source ->
                new ResponseEntity<>(MessageResourceFromEntityAssembler.toResourceFromEntity(source), CREATED))
                .orElseGet(()-> ResponseEntity.badRequest().build());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MessageResource> getMessageById(@PathVariable Long id) {
        Optional<Message> messageSource = messageQueryService.handle(new GetMessageByIdQuery(id));
        return messageSource.map(source -> ResponseEntity.ok(MessageResourceFromEntityAssembler.toResourceFromEntity(source)))
                .orElseGet(()-> ResponseEntity.notFound().build());
    }

    @GetMapping("/recipient/{recipientId}/sender/{senderId}l")
    public ResponseEntity<List<MessageResource>> getAllMessagesByRecipientAndSenderId(@PathVariable Long recipientId, @PathVariable Long senderId) {
        List<Message> messageSource = messageQueryService.handle(new GetAllMessageByRecipientAndSenderIdQuery(recipientId, senderId));
        List<MessageResource> messageResource = messageSource.stream().map(MessageResourceFromEntityAssembler::toResourceFromEntity).toList();
        return ResponseEntity.ok(messageResource);
    }
}
