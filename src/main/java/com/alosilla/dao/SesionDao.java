package com.alosilla.dao;

import com.alosilla.model.SesionRequest;
import jakarta.enterprise.context.ApplicationScoped;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@ApplicationScoped
public class SesionDao {

    // Mejor: Leer la API Key desde variable de entorno por seguridad
    private static final String OPENAI_API_KEY = "KEY"; // Reemplazar con la clave de API real
    private static final String OPENAI_ENDPOINT = "https://api.openai.com/v1/chat/completions";
    // (Opcional) Permitir configurar el modelo por variable de entorno
    private static final String OPENAI_MODEL = System.getenv().getOrDefault("OPENAI_MODEL", "gpt-4.1");

    // Reutilizar HttpClient
    private static final HttpClient client = HttpClient.newHttpClient();

    public String generarContenido(SesionRequest request, boolean mock) {
        if (mock) {
            return "---\n\n# 1. TÍTULO DE LA SESIÓN  \n**Descubriendo la Fotosíntesis: Comprendo y Organizo sus Etapas**\n\n---\n\n# 2. DATOS INFORMATIVOS\n\n- **Docente:** Giannela Peramas  \n- **Nivel y Grado:** Primaria – 3° grado  \n- **Área Curricular:** Comunicación  \n- **Tema Principal del Área:** Comprensión Lectora  \n- **Contexto Específico del Tema:** La fotosíntesis  \n- **Institución Educativa:** Andrés Bello  \n- **Duración Estimada:** 90 minutos  \n\n---\n\n# 3. PROPÓSITO DE APRENDIZAJE\n\n- **Competencia:** Lee diversos tipos de textos escritos en su lengua materna.\n- **Capacidades:** Obtiene información del texto escrito; Infiere e interpreta información del texto.\n- **Desempeño:** Identifica información explícita y relevante sobre el proceso de la fotosíntesis en un texto informativo dado.\n- **Evidencia de Aprendizaje:** Un organizador visual que sintetice las etapas de la fotosíntesis.\n- **Instrumento de Evaluación:** Lista de cotejo.\n- **Enfoques Transversales:**  \n  - **Enfoque Ambiental:**  \n    - Se promoverá la valoración del rol de las plantas en el ambiente y la importancia de la fotosíntesis para la vida.  \n    - A través de las actividades, se reflexionará sobre el cuidado del entorno y el papel de los seres humanos en la preservación de la naturaleza.\n\n---\n\n# 4. SECUENCIA DIDÁCTICA (MOMENTOS PEDAGÓGICOS)\n\n## A. INICIO (15-20%, aprox. 15-20 minutos)\n\n- **Motivación / Actividad Rompehielos:**  \n  - Proyección de un breve video interactivo (TIC) titulado “¿Cómo respiran las plantas?” utilizando una pizarra digital o tableta. Después, se pregunta:  \n    - ¿Alguna vez has imaginado cómo se alimentan las plantas?  \n    - ¿Puede una planta vivir sin luz?\n- **Recuperación de Saberes Previos:**  \n  - Preguntas guiadas:  \n    - ¿Qué saben sobre cómo viven las plantas?  \n    - ¿Por dónde obtienen su alimento las plantas?  \n    - ¿Para qué sirve la luz del sol en una planta?\n- **Conflicto Cognitivo / Problematización:**  \n  - Plantear: “Si las plantas no comen comida como nosotros, ¿entonces cómo obtienen energía para vivir? ¿Será cierto que las plantas fabrican su propio alimento?”\n- **Presentación del Propósito:**  \n  - Explicar: “Hoy aprenderemos cómo las plantas realizan la fotosíntesis, comprenderemos este proceso leyendo un texto informativo y crearemos un organizador visual para mostrar las etapas más importantes de la fotosíntesis.”\n- **Normas de Convivencia:**  \n  - Breve recordatorio: respeto al turno de palabra, escucha activa y cuidado de los materiales tecnológicos.\n\n---\n\n## B. DESARROLLO (60-70%, aprox. 55-65 minutos)\n\n### **Gestión y Acompañamiento del Docente:**\n- La docente guía la comprensión del texto informativo, facilita el trabajo en grupo y brinda retroalimentación permanente.\n- Se promueve la observación activa de la docente, quien apoya a los estudiantes con preguntas orientadoras, motiva la participación y utiliza la pizarra digital para mostrar ejemplos.\n- El docente es mediador, facilita el aprendizaje y provee el andamiaje necesario para comprensión y análisis.\n\n### **Construcción del Aprendizaje / Aplicación de Estrategias:**\n\n#### **Antes de la lectura:**\n- **Activación de conocimientos:**  \n  - Preguntar: “¿Qué propósito tenemos al leer hoy el texto sobre la fotosíntesis?”\n  - Los estudiantes anticipan información, inferida de títulos, imágenes y palabras clave destacadas en el texto que se proyectará.\n- **Establecimiento de propósito:**  \n  - “Al leer, buscaremos responder: ¿Cómo ocurre la fotosíntesis y por qué es importante?”\n\n#### **Durante la lectura:**\n- **Lectura guiada por la docente:**  \n  - Proyección del texto informativo “¿Qué es la fotosíntesis?” (en formato digital).  \n  - Lectura compartida (en voz alta y en murmullos, por turnos).\n- **Subrayado digital de ideas clave:**  \n  - Uso de la herramienta de resaltado en la pizarra digital o tabletas, marcando palabras y frases importantes sobre las etapas y condiciones de la fotosíntesis.\n- **Pausa para preguntas y aclaraciones:**  \n  - La docente formula preguntas para verificar comprensión literal e inferencial:  \n    - ¿Qué necesita la planta para hacer la fotosíntesis?\n    - ¿Qué ocurre después de que la planta recibe la luz solar?\n- **Trabajo grupal (TIC):**  \n  - Dividir la clase en grupos. Cada grupo elaborará un organizador visual (en papelógrafo o en una aplicación de mapas mentales) que sintetice los pasos de la fotosíntesis a partir de la lectura.\n  - Uso sugerido de aplicaciones sencillas (como MindMeister, Canva o Google Drawings) para quienes tienen acceso a dispositivos.\n\n#### **Después de la lectura:**\n- Puesta en común:  \n  - Cada grupo presenta su organizador visual, explicando las etapas identificadas.\n- Debate breve:  \n  - ¿Por qué creen que la fotosíntesis es importante para la vida en el planeta?\n  - ¿Qué pasaría si las plantas dejaran de hacer fotosíntesis?\n- Relación con el ambiente:  \n  - Reflexión sobre el rol ecológico de las plantas y el impacto de su cuidado en el entorno.\n\n### **Retroalimentación:**\n- Después de cada presentación grupal, la docente brinda retroalimentación descriptiva destacando los aciertos y sugiriendo mejoras dentro de un ambiente positivo.\n- Uso de preguntas guía y sugerencias según las producciones.\n\n### **Diferenciación:**\n- Apoyo adicional a estudiantes con dificultades lectoras mediante la lectura acompañada.\n- Adaptación de la complejidad del organizador para grupos con necesidades especiales.\n- Posibilidad de usar organizadores visuales impresos para estudiantes con limitaciones TIC.\n\n---\n\n## C. CIERRE (10-15%, aprox. 10-15 minutos)\n\n- **Consolidación / Sistematización:**  \n  - Repaso grupal con ayuda de la docente y revisión de organizadores para reforzar las etapas de la fotosíntesis.\n- **Metacognición:**  \n  - Preguntar:  \n    - ¿Qué aprendí hoy sobre la fotosíntesis?\n    - ¿Cómo me ayudó el organizador visual a comprender mejor?\n    - ¿Cómo pueden las plantas ayudar al cuidado del ambiente?\n- **Evaluación:**  \n  - Recolección y revisión de los organizadores visuales, contrastándolos con la lista de cotejo para comprobar si han incluido correctamente las etapas del proceso.\n- **Transferencia / Proyección:**  \n  - Reflexión: “Ahora que sabes cómo se alimentan las plantas, ¿cómo puedes cuidar mejor tu entorno y promover la siembra de plantas?”\n- **Compromisos / Tareas (opcional):**  \n  - Investigar con ayuda de su familia: ¿Qué plantas hay en mi barrio y cómo ayudan al ambiente local? Presentar una pequeña infografía o foto para la próxima clase.\n\n---\n\n# 5. RECURSOS Y MATERIALES\n\n- Pizarra digital o proyector multimedia.\n- Video interactivo sobre la fotosíntesis.\n- Texto informativo digital e impreso: “¿Qué es la fotosíntesis?”\n- Marcadores, papelotes o cartulinas para organizadores visuales.\n- Hojas blancas, lápices de colores.\n- Tablet o computadora (si está disponible) para elaborar mapas mentales virtuales.\n- Acceso a aplicaciones de organizadores visuales (MindMeister, Canva, Google Drawings) según las posibilidades.\n- Lista de cotejo impresa para evaluación.\n- Imágenes alusivas a plantas y fotosíntesis.\n\n---\n\n# 6. REFERENCIAS BIBLIOGRÁFICAS/WEBGRAFÍA\n\n- MINEDU (2016). Currículo Nacional de la Educación Básica.  \n- MINEDU. Fascículo de Comunicación Primaria 3er ciclo.  \n- Portal PerúEduca: https://www.perueduca.pe/  \n- Recurso digital de apoyo: Video “¿Qué es la fotosíntesis?” de Mundo Primaria: https://www.mundoprimaria.com/ciencias-naturales/que-es-la-fotosintesis  \n- Aplicaciones para mapas mentales: https://www.canva.com/es_mx/mapas-mentales/ ; https://www.mindmeister.com/es\n\n---\n\n**NOTA:** Esta sesión integra actividades centradas en el estudiante, promueve el uso de TIC y el enfoque ambiental, favorece el desarrollo de la comprensión lectora y la síntesis de información relevante mediante organizadores visuales, según lo requerido por el CNEB y las buenas prácticas pedagógicas.";
        }
        try {
            
            
            if (OPENAI_API_KEY == null || OPENAI_API_KEY.isBlank()) {
                return "Error: No se ha configurado la clave de API de OpenAI.";
            }
            String prompt = construirPrompt(request);
            String requestBody = crearRequestJson(prompt);

            HttpRequest httpRequest = HttpRequest.newBuilder()
                    .uri(URI.create(OPENAI_ENDPOINT))
                    .header("Content-Type", "application/json")
                    .header("Authorization", "Bearer " + OPENAI_API_KEY)
                    .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                    .build();

            HttpResponse<String> response = client.send(httpRequest, HttpResponse.BodyHandlers.ofString());

            return extraerRespuesta(response.body());

        } catch (IOException | InterruptedException e) {
            // Mejor manejo de errores
            Thread.currentThread().interrupt();
            return "Error al generar el contenido: " + e.getMessage();
        } catch (Exception e) {
            return "Error inesperado: " + e.getMessage();
        }
    }

    private String construirPrompt(SesionRequest r) {
        return """
            ### PLANTILLA DE PROMPT PARA GENERACIÓN DE SESIONES DE APRENDIZAJE (MINEDU - PERÚ)

                **Objetivo del Prompt:** Generar una sesión de aprendizaje completa y estructurada, siguiendo las directrices pedagógicas del Ministerio de Educación del Perú, adaptada a un contexto y necesidades específicas.

                **Instrucciones Generales para la IA:**
                Actúa como un especialista en diseño curricular y didáctico para la Educación Básica Regular del Perú. Tu tarea es elaborar una sesión de aprendizaje detallada que fomente el desarrollo de competencias, promueva el aprendizaje activo y significativo, e integre los momentos pedagógicos clave. El diseño debe ser coherente con el Currículo Nacional de la Educación Básica (CNEB) y las buenas prácticas pedagógicas.

                ---

                **VARIABLES DE ENTRADA (Input para la IA):**

                * **DOCENTE_NOMBRE**: %s
                * **NIVEL_EDUCATIVO**: %s
                * **GRADO_EDUCATIVO**: %s
                * **AREA_CURRICULAR**: %s
                * **TEMA_PRINCIPAL_AREA**: %s
                * **CONTEXTO_ESPECIFICO_TEMA**: %s
                * **INSTITUCION_EDUCATIVA**: %s
                * **DURACION_ESTIMADA_MINUTOS**: %d
                * **COMPETENCIA_CNEB**: %s
                * **CAPACIDADES_CNEB**: %s
                * **DESEMPENIO_ESPECIFICO**: %s
                * **EVIDENCIA_DE_APRENDIZAJE**: %s
                * **INSTRUMENTO_DE_EVALUACION**: %s
                * **ENFOQUES_TRANSVERSALES_PRIORITARIOS**: %s
                * **OBSERVACIONES_ADICIONALES**: %s

                ---

                **ESTRUCTURA DE LA SESIÓN DE APRENDIZAJE A GENERAR:**

                La sesión debe presentarse con la siguiente estructura y contenido detallado:

                **1. TÍTULO DE LA SESIÓN:** (Generado por la IA, claro, atractivo y relacionado con el propósito y el tema)

                **2. DATOS INFORMATIVOS:**
                    * **Docente:** DOCENTE_NOMBRE
                    * **Nivel y Grado:** NIVEL_EDUCATIVO - GRADO_EDUCATIVO
                    * **Área Curricular:** AREA_CURRICULAR
                    * **Tema Principal del Área:** TEMA_PRINCIPAL_AREA
                    * **Contexto Específico del Tema:** CONTEXTO_ESPECIFICO_TEMA
                    * **Institución Educativa:** INSTITUCION_EDUCATIVA
                    * **Duración Estimada:** DURACION_ESTIMADA_MINUTOS minutos

                **3. PROPÓSITO DE APRENDIZAJE:**
                    * **Competencia:** COMPETENCIA_CNEB
                    * **Capacidades:** CAPACIDADES_CNEB
                    * **Desempeño:** DESEMPENIO_ESPECIFICO
                    * **Evidencia de Aprendizaje:** EVIDENCIA_DE_APRENDIZAJE
                    * **Instrumento de Evaluación:** INSTRUMENTO_DE_EVALUACION
                    * **Enfoques Transversales:** (Detallar cómo se manifestará ENFOQUES_TRANSVERSALES_PRIORITARIOS en la sesión)

                **4. SECUENCIA DIDÁCTICA (MOMENTOS PEDAGÓGICOS):**

                    * **A. INICIO (Duración estimada: 15-20%% del total)**
                        * **Motivación / Actividad Rompehielos:** Actividad introductoria que capte la atención y despierte el interés de los estudiantes, preferiblemente vinculada al CONTEXTO_ESPECIFICO_TEMA.
                        * **Recuperación de Saberes Previos:** Preguntas estratégicas que activen conocimientos previos relevantes para el tema.
                        * **Conflicto Cognitivo / Problematización:** Pregunta o situación desafiante que genere la necesidad de aprender sobre el CONTEXTO_ESPECIFICO_TEMA.
                        * **Presentación del Propósito:** Clarificación del objetivo de la sesión y del DESEMPENIO_ESPECIFICO y EVIDENCIA_DE_APRENDIZAJE.
                        * **Normas de Convivencia (si aplica):** Recordatorio o establecimiento de acuerdos para el desarrollo de la sesión.

                    * **B. DESARROLLO (Duración estimada: 60-70%% del total)**
                        * **Gestión y Acompañamiento del Docente:**
                            * Descripción de las estrategias y acciones que el docente realizará para guiar el aprendizaje.
                            * Rol del docente: Observador, facilitador, proveedor de retroalimentación, etc.
                        * **Construcción del Aprendizaje / Aplicación de Estrategias:**
                            * **Antes de la lectura/actividad principal:** (Si aplica para comprensión lectora, investigación, etc.) Estrategias de pre-activación, predicción, establecimiento de propósitos de lectura.
                            * **Durante la lectura/actividad principal:** Detalle paso a paso de las actividades que los estudiantes realizarán. Deben ser variadas (individuales, en parejas, grupales) y orientadas al DESEMPENIO_ESPECIFICO. Incluir uso de organizadores, análisis, experimentación, etc.
                            * **Después de la lectura/actividad principal:** Actividades para la consolidación, aplicación y profundización del CONTEXTO_ESPECIFICO_TEMA.
                        * **Retroalimentación:** Momentos explícitos donde el docente brindará retroalimentación formativa a los estudiantes (por descubrimiento, descriptiva, por andamiaje).
                        * **Diferenciación (si aplica):** Breve mención de cómo se atenderán las diversas necesidades de los estudiantes.

                    * **C. CIERRE (Duración estimada: 10-15%% del total)**
                        * **Consolidación / Sistematización:** Breve resumen o síntesis de los aprendizajes clave logrados en relación con el DESEMPENIO_ESPECIFICO y CONTEXTO_ESPECIFICO_TEMA.
                        * **Metacognición:** Preguntas que inviten a los estudiantes a reflexionar sobre su propio proceso de aprendizaje (¿Qué aprendí?, ¿Cómo lo aprendí?, ¿Para qué me sirve?).
                        * **Evaluación:** Momento para la recolección de la EVIDENCIA_DE_APRENDIZAJE y aplicación del INSTRUMENTO_DE_EVALUACION.
                        * **Transferencia / Proyección:** Cómo lo aprendido se conecta con otras áreas o la vida diaria.
                        * **Compromisos / Tareas (opcional):** Actividades de extensión o refuerzo.

                **5. RECURSOS Y MATERIALES:**
                    * Enumeración detallada de los materiales que se utilizarán (textos, imágenes, material concreto, TIC, pizarra, etc.).

                **6. REFERENCIAS BIBLIOGRÁFICAS/WEBGRAFÍA:** (Si se usaron recursos específicos, mencionar fuentes relevantes del MINEDU o didácticas).

                ---

                **Criterios de Calidad para la IA:**
                * **Claridad y Coherencia:** El lenguaje debe ser claro y la sesión lógicamente estructurada.
                * **Pertinencia:** Las actividades deben ser adecuadas para el NIVEL_EDUCATIVO y GRADO_EDUCATIVO, y relevantes para el TEMA_PRINCIPAL_AREA y CONTEXTO_ESPECIFICO_TEMA.
                * **Enfoque por Competencias:** Cada actividad debe contribuir explícitamente al desarrollo de la COMPETENCIA_CNEB y las CAPACIDADES_CNEB, evidenciando el DESEMPENIO_ESPECIFICO.
                * **Actividad y Participación:** Las actividades deben promover la participación activa, la interacción y el pensamiento crítico de los estudiantes.
                * **Innovación (opcional):** Sugerir ideas creativas o el uso de TIC cuando sea pertinente.
                * **Formato:** Usar encabezados y viñetas para una fácil lectura.

                **INICIA LA GENERACIÓN DE LA SESIÓN DE APRENDIZAJE UTILIZANDO LAS VARIABLES PROPORCIONADAS.**
            """.formatted(
                r.getDocenteNombre(),
                r.getNivelEducativo(),
                r.getGradoEducativo(),
                r.getAreaCurricular(),
                r.getTemaPrincipalArea(),
                r.getContextoEspecificoTema(),
                r.getInstitucionEducativa(),
                r.getDuracionEstimadaMinutos(),
                r.getCompetenciaCneb(),
                r.getCapacidadesCneb(),
                r.getDesempenioEspecifico(),
                r.getEvidenciaDeAprendizaje(),
                r.getInstrumentoDeEvaluacion(),
                r.getEnfoquesTransversalesPrioritarios(),
                r.getObservacionesAdicionales()
        );
    }

    private String crearRequestJson(String prompt) {
        return new JSONObject()
                .put("model", OPENAI_MODEL)
                .put("messages", new JSONArray()
                        .put(new JSONObject()
                                .put("role", "user")
                                .put("content", prompt)))
                .toString();
    }

    private String extraerRespuesta(String responseBody) {
        try {
            JSONObject json = new JSONObject(responseBody);
            JSONArray choices = json.optJSONArray("choices");
            if (choices != null && !choices.isEmpty()) {
                JSONObject message = choices.getJSONObject(0).optJSONObject("message");
                if (message != null && message.has("content")) {
                    return message.getString("content").trim();
                }
            }
            return "No se recibió una respuesta válida de la API.";
        } catch (Exception e) {
            return "Error al procesar la respuesta de la API: " + e.getMessage();
        }
    }
}
