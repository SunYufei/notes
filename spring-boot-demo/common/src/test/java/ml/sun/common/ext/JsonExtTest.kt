package ml.sun.common.ext

import com.fasterxml.jackson.databind.ObjectMapper
import ml.sun.common.ext.JsonExt.asList
import ml.sun.common.ext.JsonExt.asMap
import ml.sun.common.ext.JsonExt.asObj
import ml.sun.common.ext.JsonExt.getBoolean
import ml.sun.common.ext.JsonExt.toList
import ml.sun.common.ext.JsonExt.toMap
import ml.sun.common.ext.JsonExt.toObj
import ml.sun.common.util.SpringUtil
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig

@SpringJUnitConfig(SpringUtil::class, ObjectMapper::class)
class JsonExtTest {
    @Test
    fun obj() {
        data class Test(val success: Boolean, val code: Int, val message: String)

        val json = """{ "success": true, "code": 0, "message": "" }"""
        val obj = json.toObj(Test::class)

        assertEquals(obj.success, true)
        assertEquals(obj.code, 0)
        assertEquals(obj.message, "")

        val node = json.toObj()
        assertTrue(node.getBoolean("success"))

        assertEquals(obj, node.asObj(Test::class))
    }

    @Test
    fun list() {
        val strList = """["first", "second", "third", "fourth"]""".toList(String::class)

        assertEquals(strList[0], "first")
        assertEquals(strList.size, 4)

        val intList = "[0, 1, 2, 3]".toList(Int::class)

        assertEquals(intList[0], 0)
        assertEquals(intList.size, 4)

        val boolList = """[true, false]""".toObj().asList(Boolean::class)
        assertTrue(boolList[0])
    }

    @Test
    fun map() {
        val json = """{ "key": "value", "success": true }"""
        val map = json.toMap(Any::class)

        assertEquals(map["key"], "value")
        assertEquals(map["success"], true)
        assertEquals(json.toObj().asMap(Any::class), map)
    }
}
