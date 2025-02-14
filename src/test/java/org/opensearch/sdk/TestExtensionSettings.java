package org.opensearch.sdk;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.opensearch.test.OpenSearchTestCase;

import java.io.File;

public class TestExtensionSettings extends OpenSearchTestCase {

    private ExtensionSettings extensionSettings;

    @Override
    @BeforeEach
    public void setUp() throws Exception {
        super.setUp();
        File file = new File(ExtensionSettings.EXTENSION_DESCRIPTOR);
        ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());
        extensionSettings = objectMapper.readValue(file, ExtensionSettings.class);
    }

    @Test
    public void testExtensionName() {
        assertEquals("sample-extension", extensionSettings.getExtensionName());
    }

    @Test
    public void testHostAddress() {
        assertEquals("127.0.0.1", extensionSettings.getHostAddress());
    }

    @Test
    public void testHostPort() {
        assertEquals("4532", extensionSettings.getHostPort());
    }

    @Test
    public void testConstructorWithArgs() {
        ExtensionSettings settings = new ExtensionSettings("foo", "bar", "baz");
        assertEquals("foo", settings.getExtensionName());
        assertEquals("bar", settings.getHostAddress());
        assertEquals("baz", settings.getHostPort());
    }
}
