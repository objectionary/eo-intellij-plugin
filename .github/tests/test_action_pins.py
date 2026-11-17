# SPDX-FileCopyrightText: Copyright (c) 2021-2025 Stepan Strunkov
# SPDX-License-Identifier: MIT
"""Keep the third-party workflow actions from issue #96 immutable."""

from pathlib import Path
import re
import unittest


class ActionPinsTest(unittest.TestCase):
    def test_actions_use_commit_shas(self):
        workflows = Path(__file__).resolve().parents[1] / "workflows"
        for workflow, action in (
            ("xcop", "g4s8/xcop-action"),
            ("pdd", "volodya-lombrozo/pdd-action"),
        ):
            with self.subTest(action=action):
                content = (workflows / f"{workflow}.yml").read_text()
                references = re.findall(
                    rf"uses:\s*{re.escape(action)}@([^\s#]+)", content
                )
                self.assertTrue(references, f"Missing action {action}")
                for reference in references:
                    self.assertRegex(reference, r"^[0-9a-f]{40}$")
